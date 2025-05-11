package vista;

import controlador.Navegador;

public class Main {
	private static final String URL = "jdbc:postgresql://localhost:5432/Proyecto";

	public static void main(String[] args) {
		VentanaPrincipal ventanaPrincipal = new VentanaPrincipal();
		Navegador.agregarVentana(ventanaPrincipal);
		Navegador.dispatcher("VentanaPrincipal", true);



	}

}
