package controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GestionBaseDeDatos {
	private static final String URL = "jdbc:postgresql://localhost:5432/Proyecto";
	
	
	public boolean comprobarConexion(String user, String password) {
		try (Connection con = DriverManager.getConnection(URL, user, password)) {
			return true;
		} catch (SQLException e) {
			return false;
		}
	}
	
}
