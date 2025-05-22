package util;

import java.sql.*;
import java.util.ArrayList;

public class BaseDatosController {
	private static final String URL = "jdbc:postgresql://localhost:5432/Proyecto";
	private final String USER = "postgres";
	private final String PASSWORD = "postgres";
	private Connection connection;

	public boolean comprobarConexion(String user, String password) {
		try (Connection con = DriverManager.getConnection(URL, user, password)) {
			return true;
		} catch (SQLException e) {
			return false;
		}
	}
	
	public Connection conexionBD() {
		try {
	        connection = DriverManager.getConnection(URL, USER, PASSWORD);
	        return connection;			
		} catch (SQLException e) {
			return null;
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


	public void actualizarCeldaTabla(String nombreTabla, String nombreColumna, String nombrePK, Object valorPK, Object nuevoValor) {
		try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD)) {
			String sql = "UPDATE " + nombreTabla + " SET " + nombreColumna + " = " + "?" + " WHERE " + nombrePK + "= ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setObject(1, nuevoValor);
			ps.setObject(2, valorPK);
			System.out.println(sql);
			ps.executeUpdate();
		}catch (SQLException e) {

		}
	}



	
}
