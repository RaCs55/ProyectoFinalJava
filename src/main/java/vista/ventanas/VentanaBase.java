package vista.ventanas;

import javax.swing.*;

import controlador.ControladorTablas;
import controlador.Navegador;

import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public abstract class VentanaBase extends JFrame {
	private static final long serialVersionUID = 1L;
	protected JTable tabla;
	protected ControladorTablas controladorTablas;
	protected String tablaActual;
	protected boolean editable = false;

	public VentanaBase(String titulo, ControladorTablas controladorTablas, String[] tablasDisponibles) {
		this.controladorTablas = controladorTablas;
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				Navegador.dispatcher("VentanaMenu", true);
				
			}
		});
		setTitle(titulo);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(600, 400);
		setLocationRelativeTo(null);

		inicializarUI(tablasDisponibles);
		configurarComponentesAdicionales();
	}

	private void inicializarUI(String[] tablasDisponibles) {
		JPanel panel = new JPanel();
		panel.setLayout(null);
		setContentPane(panel);

		// Configuración de la tabla
		tabla = new JTable();
		JScrollPane scrollPane = new JScrollPane(tabla);
		scrollPane.setBounds(0, 50, 584, 233);
		panel.add(scrollPane);

		// Menú de vistas
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 584, 30);
		panel.add(menuBar);

		JMenu menuVistas = new JMenu("Vistas");
		menuBar.add(menuVistas);

		for (String tablaNombre : tablasDisponibles) {
			JMenuItem item = new JMenuItem(tablaNombre);
			item.addActionListener(e -> actualizarTabla(tablaNombre));
			menuVistas.add(item);
		}

		// Botones comunes
		JButton btnEditar = new JButton("Editar Tabla");
		btnEditar.setBounds(20, 300, 120, 30);
		btnEditar.addActionListener(e -> alternarEdicion(e));
		panel.add(btnEditar);
	}

	protected abstract void configurarComponentesAdicionales();

	public void actualizarTabla(String nombreTabla) {
		this.tablaActual = nombreTabla;
		tabla.setModel(controladorTablas.obtenerModeloTabla(nombreTabla));
	}

	private void alternarEdicion(ActionEvent e) {
		editable = !editable;
		tabla.setModel(controladorTablas.obtenerModeloTabla(tablaActual));
	}
}