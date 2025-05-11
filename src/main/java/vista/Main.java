package vista;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import controlador.GestionBaseDeDatos;
import controlador.Navegador;

public class Main {
	private static final String URL = "jdbc:postgresql://localhost:5432/Proyecto";

	public static void main(String[] args) {
		VentanaPrincipal ventanaPrincipal = new VentanaPrincipal();
		Navegador.agregarVentana(ventanaPrincipal);
		Navegador.dispatcher("VentanaPrincipal", true);



	}

}
