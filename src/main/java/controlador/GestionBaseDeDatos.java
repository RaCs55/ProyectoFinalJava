package controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GestionBaseDeDatos {
	String url = "jdbc:postgresql://localhost:5432/Proyecto";
	String user = "postgres";
	String password = "postgres";
	
	
	public void prueba() {
		try (Connection con = DriverManager.getConnection(url, user, password)) {

			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
