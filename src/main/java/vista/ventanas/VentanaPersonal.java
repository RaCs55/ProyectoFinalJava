package vista.ventanas;

import javax.swing.JButton;

import controlador.ControladorTablas;

public class VentanaPersonal extends VentanaBase {

	private static final long serialVersionUID = 1L;
	private static final String[] TABLAS = {"TRABAJADOR", "COCINERO", "CAMARERO", "GERENTE"};


	//TRABAJADOR, COCINERO, CAMARERO, GERENTE

	public VentanaPersonal(ControladorTablas controladorTablas) {

		super("VentanaPersonal", controladorTablas, TABLAS);
		
	}
	
	 @Override
	    protected void configurarComponentesAdicionales() {
	        JButton btnAgregar = new JButton("Agregar");
	        btnAgregar.setBounds(160, 300, 120, 30);
	        btnAgregar.addActionListener(e -> mostrarDialogoAgregar());
	        getContentPane().add(btnAgregar);
	    }

	    private void mostrarDialogoAgregar() {
	    }


}
