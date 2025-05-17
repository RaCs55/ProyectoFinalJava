package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTable;

import vista.VentanaAgregar;

public class GestionVentanas {
	private ControladorBD gestion = new ControladorBD();
	private ControladorTablas controladorTablas;
	private String nombreTabla = "FACTURA";
	private JTable tabla;
	

	public GestionVentanas(JTable tabla) {
		this.tabla = tabla;
		this.controladorTablas = new ControladorTablas(tabla);
	}

	
	public void crearMenuItems(JMenu menu, String[] nombres) {
		for (String itemText : nombres) {
            JMenuItem menuItem = new JMenuItem(itemText);
            menu.add(menuItem);
            
            menuItem.addActionListener(e -> {
            	controladorTablas.actualizarTabla(itemText);
            	nombreTabla = itemText;
            });
        }
	}




	
	public void botonAgregar(String nombreVentanaProveniente, JPanel panel) {
		JButton btnAgregar= new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				VentanaAgregar ventanaAgregar = new VentanaAgregar(nombreTabla, nombreVentanaProveniente, tabla);
				ventanaAgregar.setVisible(true);
				Navegador.dispatcher(nombreVentanaProveniente, false);
			}
		});
		btnAgregar.setBounds(394, 294, 133, 23);
		panel.add(btnAgregar);

	
	}
	

	

}
