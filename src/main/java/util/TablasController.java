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
	
	public TablasController(JTable tabla) {
		this.tabla = tabla;
	}





	public String[] getColumnNames(String nameTable) {
		List<String> columnNames = controladorBD.obtenerNombreColumnas(nameTable);
		return columnNames.toArray(new String[0]);
	}

	public TableModelListener registrarTablasListener(String nombreTablaActual) {
		return e -> {
			System.out.println("Listener activado. Tipo de evento: " + e.getType());
			if (e.getType() == TableModelEvent.UPDATE) {
				int column = tabla.getSelectedColumn();
				int row = tabla.getSelectedRow();
				System.out.println("Update en fila: " + row + ", columna: " + column);

				String nombreColumna = tabla.getColumnName(column);
				String nombrePK = tabla.getColumnName(0);

				Object value = tabla.getModel().getValueAt(row, column);

				if (value instanceof String ) {
					String valueString = (String) value;
					try {
						int i = Integer.parseInt(valueString);
						System.out.println("Es integer (convertido): " + i);
						value = i;

					} catch (NumberFormatException e1) {
						try {
							double d = Double.parseDouble(valueString);
							System.out.println("Es double (convertido): " + d);
							value = d;
						} catch (NumberFormatException e2) {
							System.out.println("No es número, sigue siendo string");
						}
					}
				}

				Object valuePK = tabla.getValueAt(row, 0);

				System.out.println("Actualizando: " + nombreColumna + " = " + value + " donde " + nombrePK + " = " + valuePK);

				BaseDatosController baseDatosController = new BaseDatosController();
				baseDatosController.actualizarCeldaTabla(nombreTablaActual, nombreColumna, nombrePK, valuePK, value);
			}
		};
	}


	public void actualizarTabla(String nombreTabla) {
		Object[][] data = null;
		FileController fileController = new FileController();
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
			default:
				System.out.println("ERROR ");
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
		}
	}
	
	
	public void setEsEditable(boolean esEditable) {
		this.esEditable = esEditable;
	}
	
	public boolean getEsEditable() {
		return esEditable;
	}
	
}
