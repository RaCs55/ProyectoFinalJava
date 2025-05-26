package controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ControladorBD {
	private static final String URL = "jdbc:postgresql://localhost:5432/Proyecto";
	private final String USER = "postgres";
	private final String PASSWORD = "postgres";
	
	
	public boolean comprobarConexion(String usuario, String contrasena) {
        try (Connection con = DriverManager.getConnection(URL, usuario, contrasena)) {
            return true;
        } catch (SQLException e) {
            return false;
        }
    }	
	
	public ArrayList<ArrayList<Object>> obtenerDatosTabla(String nombreTabla) {
		ArrayList<ArrayList<Object>> data = new ArrayList<>();
		try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD)) {
			String sql = "SELECT * FROM " + nombreTabla;
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			ResultSetMetaData rsmd = rs.getMetaData();
			
			int totalColumnas = rsmd.getColumnCount();
			
			while (rs.next()) {
				ArrayList<Object> fila = new ArrayList<>();
				for (int i = 1; i <= totalColumnas; i++) {
					fila.add(rs.getObject(i));
				}
				data.add(fila);
			}
			
			return data;
			
		} catch (SQLException e) {
			return null;
		}
	}
	
	public ArrayList<String> obtenerNombreColumnas(String nombreTabla) {
		ArrayList<String> nombres = new ArrayList<>();
		try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD)) {
			String sql = "SELECT * FROM " + nombreTabla;
			Statement st = con.createStatement();
			
			ResultSet rs = st.executeQuery(sql);
			ResultSetMetaData rsmd = rs.getMetaData();
			
			int totalColumnas = rsmd.getColumnCount();
				for (int i = 1; i <= totalColumnas; i++) {
					nombres.add(rsmd.getColumnName(i));
				}
			
			return nombres;
			
		} catch (SQLException e) {
			
			return null;
		}
	

	}
}
