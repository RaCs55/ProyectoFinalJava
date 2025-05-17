package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controlador.ControladorBD;
import controlador.ControladorTablas;
import controlador.GestionVentanas;
import controlador.Navegador;

public class VentanaPersonal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private boolean esEditable;
	private String nombreTabla = "TRABAJADOR";
	private ControladorBD gestion = new ControladorBD();
	private JMenuItem mntmCliente;

	//TRABAJADOR, COCINERO, CAMARERO, GERENTE
	public VentanaPersonal() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				Navegador.dispatcher("VentanaMenu", true);
				
			}
		});
		
		setTitle("VentanaPersonal");
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
		scrollPane.setViewportView(table);

		GestionVentanas gestionVentanas = new GestionVentanas(table);
		ControladorTablas controladorTablas = new ControladorTablas(table);


		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 584, 22);
		panel.add(menuBar);

		JMenu mnVistas = new JMenu("Vistas");
		menuBar.add(mnVistas);
		
		String[] nombres = {"TRABAJADOR", "COCINERO", "CAMARERO", "GERENTE"};
		gestionVentanas.crearMenuItems(mnVistas, nombres);

		
		JButton btnEditarTabla = new JButton("Editar Tabla");
		btnEditarTabla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controladorTablas.setEsEditable(!controladorTablas.getEsEditable());

			}
		});
		
		
		btnEditarTabla.setBounds(23, 294, 89, 23);
		panel.add(btnEditarTabla);
		
		JButton btnGuardarDatos = new JButton("Guardar Datos");
		btnGuardarDatos.setBounds(237, 294, 89, 23);
		panel.add(btnGuardarDatos);
		
		gestionVentanas.botonAgregar(getTitle(), panel);

	}


}
