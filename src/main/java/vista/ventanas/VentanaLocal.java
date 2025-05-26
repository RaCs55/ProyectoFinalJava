package vista.ventanas;



import javax.swing.JButton;

import controlador.ControladorTablas;

public class VentanaLocal extends VentanaBase {

	private static final long serialVersionUID = 1L;
	private static final String[] TABLAS = {"PROVEEDOR", "ALIMENTO", "LOCAL"};
	
	//PROVEEDOR, ALIMENTO, LOCAL
	
	public VentanaLocal(ControladorTablas controladorTablas) {

		super("VentanaLocal", controladorTablas, TABLAS);
		
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



