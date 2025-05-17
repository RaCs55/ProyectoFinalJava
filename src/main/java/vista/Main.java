package vista;

import controlador.Navegador;

public class Main {

	public static void main(String[] args) {
		VentanaPrincipal ventanaPrincipal = new VentanaPrincipal();
		Navegador.agregarVentana(ventanaPrincipal);
		Navegador.dispatcher("VentanaPrincipal", true);

		
	}

}
