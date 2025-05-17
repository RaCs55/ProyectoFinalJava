package controlador;

import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ControladorTablas {
	private ControladorBD controladorBD = new ControladorBD();
	private boolean esEditable;
	private JTable tabla;
	
	public ControladorTablas(JTable tabla) {
		this.tabla = tabla;
	}
	
	
	public Object[][] rellenarData(String nombreTabla) {
		ArrayList<ArrayList<Object>> tabla = controladorBD.obtenerDatosTabla(nombreTabla);

		if (tabla != null) {

			int columnas = tabla.get(0).size();
			int filas = tabla.size();

			Object[][] data = new Object[filas][columnas];
			for (int i = 0; i < filas; i++) {
				for (int j = 0; j < columnas; j++) {
					data[i][j] = tabla.get(i).get(j);
				}
			}

			return data;
		}

		return null;

	}
	
	public void actualizarTabla(String nombreTabla) {
		Object[][] data = rellenarData(nombreTabla);
		String[] nombresColumna = controladorBD.obtenerNombreColumnas(nombreTabla).toArray(new String[0]);

		if (data != null) {
			DefaultTableModel model = new DefaultTableModel(data, nombresColumna) {
			    @Override
			    public boolean isCellEditable(int row, int column) {
			       //all cells false
			       return esEditable;
			    }
			};
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
