package vista.ventanas;

import javax.swing.JButton;

import controlador.ControladorTablas;

public class VentanaOperaciones extends VentanaBase {

	private static final long serialVersionUID = 1L;
	private static final String[] TABLAS = {"PEDIDO", "PRODUCTO", "FACTURA", "PROPINA", "CLIENTE", "MESA"};


	// PEDIDO, PRODUCTO, FACTURA, PROPINA, CLIENTE, MESA

	public VentanaOperaciones(ControladorTablas controladorTablas) {

		super("VentanaOperaciones", controladorTablas, TABLAS);
		
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
