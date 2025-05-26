package controlador;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

public class ControladorTablas {
		private ControladorBD controladorBD;
		
		

	    public ControladorTablas() {
		}

		public DefaultTableModel obtenerModeloTabla(String nombreTabla) {
	        Object[][] datos = rellenarData("PRODUCTO");
	        String[] nombresColumnas = rellenarNombresColumnas("PRODUCTO");
	        
	        return new DefaultTableModel(datos, nombresColumnas) {
	            @Override
	            public boolean isCellEditable(int row, int column) {
	                return false;
	            }
	        };
	    }

	    private Object[][] rellenarData(String nombreTabla) {
	        ArrayList<ArrayList<Object>> tabla = controladorBD.obtenerDatosTabla(nombreTabla);
	        
	        if (tabla == null || tabla.isEmpty()) {
	            return new Object[0][0];
	        }

	        int filas = tabla.size();
	        int columnas = tabla.get(0).size();
	        Object[][] datos = new Object[filas][columnas];
	        
	        for (int i = 0; i < filas; i++) {
	            for (int j = 0; j < columnas; j++) {
	                datos[i][j] = tabla.get(i).get(j);
	            }
	        }
	        
	        return datos;
	    }

	    private String[] rellenarNombresColumnas(String nombreTabla) {
	        ArrayList<String> nombres = controladorBD.obtenerNombreColumnas(nombreTabla);
	        return nombres.toArray(new String[0]);
	    }
}
