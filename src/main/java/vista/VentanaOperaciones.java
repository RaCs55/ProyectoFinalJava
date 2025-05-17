package vista;


import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import controlador.ControladorTablas;
import controlador.GestionVentanas;
import controlador.Navegador;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class VentanaOperaciones extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private boolean esEditable;

	// PEDIDO, PRODUCTO, FACTURA, PROPINA, CLIENTE, MESA

	public VentanaOperaciones() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				Navegador.dispatcher("VentanaMenu", true);
				
			}
		});
		setTitle("VentanaOperaciones");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(600, 400);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 584, 361);
		contentPane.add(panel);
		panel.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 22, 584, 233);
		panel.add(scrollPane);

		JTable table = new JTable();
		GestionVentanas gestionVentana = new GestionVentanas(table);
		ControladorTablas controladorTablas = new ControladorTablas(table);

		
		scrollPane.setViewportView(table);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 584, 22);
		panel.add(menuBar);

		JMenu mnVistas= new JMenu("Vistas");
		menuBar.add(mnVistas);
		
		String[] nombres = {"PEDIDO", "PRODUCTO", "FACTURA", "PROPINA", "CLIENTE", "MESA"};
		gestionVentana.crearMenuItems(mnVistas, nombres);


	
		JButton btnEditarTabla = new JButton("Editar Tabla");
		btnEditarTabla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controladorTablas.setEsEditable(!controladorTablas.getEsEditable());
			}
		});
		
		
		btnEditarTabla.setBounds(23, 294, 89, 23);
		panel.add(btnEditarTabla);
		
		JButton btnGuardarDatos = new JButton("Eliminar");
		btnGuardarDatos.setBounds(237, 294, 89, 23);
		panel.add(btnGuardarDatos);
		
		gestionVentana.botonAgregar(getTitle(), panel);


	}

}
