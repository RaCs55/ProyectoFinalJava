package util;

import java.util.ArrayList;

import javax.swing.JFrame;

public class Navegador {
	private static ArrayList<JFrame> ventanas = new ArrayList<JFrame>();

	public static void agregarVentana(JFrame v) {
		ventanas.add(v);
	}

	public static void dispatcher(String titulo, boolean visibilidad) {
		for (JFrame ventana : ventanas) {
			if (ventana.getTitle().equalsIgnoreCase(titulo)) {
				ventana.setVisible(visibilidad);
			}
		}
	}

	public static boolean isCreate(String titulo) {
		for (JFrame ventana : ventanas) {
			if (ventana.getTitle().equals(titulo)) {
				return true;
			}
		}
		return false;
	}
}
