package util;

import controlador.*;

import java.util.List;

import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

public class TablasController {
	private BaseDatosController controladorBD = new BaseDatosController();
	private boolean esEditable;
	private JTable tabla;
	private Object valorPKAnterior;

	public TablasController(JTable tabla) {
		this.tabla = tabla;
	}


	public TableModelListener registrarTablasListener(String nombreTablaActual) {
		return e -> {
			if (e.getType() == TableModelEvent.UPDATE) {
				int row = tabla.getSelectedRow();
				int column = tabla.getSelectedColumn();

				Object valuePK = valorPKAnterior;
				System.out.println(row + " " + column);
				System.out.println(valuePK);

				String nombreColumna = tabla.getColumnName(column);
				String nombrePK = tabla.getColumnName(0);

				Object value = tabla.getModel().getValueAt(row, column);

				if (value instanceof String ) {
					String valueString = (String) value;
					try {
						int i = Integer.parseInt(valueString);
						value = i;

					} catch (NumberFormatException e1) {
						try {
							double d = Double.parseDouble(valueString);
							value = d;
						} catch (NumberFormatException e2) {
							GestionErrores.mostrarError(GestionErrores.TipoError.DATOS_INVALIDOS, "El campo introducido es invalido.", null);
						}
					}
				}
				BaseDatosController baseDatosController = new BaseDatosController();
				baseDatosController.actualizarCeldaTabla(nombreTablaActual, nombreColumna, nombrePK, valuePK, value);
			}
		};
	}


	public void actualizarTabla(String nombreTabla) {
		Object[][] data = null;
		switch (nombreTabla) {
			case "Producto":
				data = ProductoController.obtenerValores();
				break;
			case "Trabajador":
				data = TrabajadorController.obtenerValores();
				break;
			case "Proveedor":
				data = ProveedorController.obtenerValores();
				break;
			case "Pedido":
				data = PedidoController.obtenerValores();
				break;
			case "Factura":
				data = FacturaController.obtenerValores();
				break;
		}

		String[] nombresColumna = controladorBD.obtenerNombreColumnas(nombreTabla).toArray(new String[0]);

		if (data != null) {

			DefaultTableModel model = new DefaultTableModel(data, nombresColumna) {
			    @Override
			    public boolean isCellEditable(int row, int column) {
			       return esEditable;
			    }
			};
			model.addTableModelListener(registrarTablasListener(nombreTabla));
			tabla.setModel(model);
			tabla.getSelectionModel().addListSelectionListener(event -> {
				if (!event.getValueIsAdjusting() && tabla.getSelectedRow() != -1) {
					valorPKAnterior = tabla.getValueAt(tabla.getSelectedRow(), 0);
				}
			});
		}
	}
	
	
	public void setEsEditable(boolean esEditable) {
		this.esEditable = esEditable;
	}
	
	public boolean getEsEditable() {
		return esEditable;
	}


	
}
