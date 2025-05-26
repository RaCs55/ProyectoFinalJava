package vista;

import util.Navegador;
import estilos.Estilos;


public class Main {

	public static void main(String[] args) {
		Estilos.aplicarEstilos();
		VentanaPrincipal ventanaPrincipal = new VentanaPrincipal();
		Navegador.agregarVentana(ventanaPrincipal);
		Navegador.dispatcher("VentanaPrincipal", true);
	}
}
