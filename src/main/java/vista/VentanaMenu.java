package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import controlador.Navegador;

public class VentanaMenu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTable table;

	public VentanaMenu() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				Navegador.dispatcher("VentanaPrincipal", true);
			}
		});
		setTitle("VentanaMenu");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setSize(1200, 800);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());

		getContentPane().add(panelArriba(), BorderLayout.NORTH);
		getContentPane().add(panelCentral(), BorderLayout.CENTER);
		getContentPane().add(panelIzquierda(), BorderLayout.WEST);
		getContentPane().add(panelAbajo(), BorderLayout.SOUTH);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu("New menu");
		menuBar.add(mnNewMenu);

		JMenuItem mntmNewMenuItem = new JMenuItem("New menu item");
		mnNewMenu.add(mntmNewMenuItem);

	}

	public JPanel panelArriba() {
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());

		JLabel titulo = new JLabel("LOS POLLOS HERMANOS");
		titulo.setFont(new Font("Arial", Font.BOLD, 24));
		panel.add(titulo, "");

		return panel;
	}

	public JPanel panelCentral() {
		JPanel panel = new JPanel(new BorderLayout());
		JScrollPane scrollPane = new JScrollPane();
        String[] columnas = {"Nombre", "Edad"};
        Object[][] datos = {{"Ana", 25}, {"Luis", 30}};
		JTable tabla = new JTable(datos, columnas);

		scrollPane.setViewportView(tabla);
		panel.add(scrollPane, BorderLayout.CENTER);

		return panel;
	}

	public JPanel panelIzquierda() {
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

		JButton btn1 = new JButton("Boton 1");
		panel.add(btn1);
		panel.add(Box.createVerticalStrut(10));


		JButton btn2 = new JButton("Boton 2");
		panel.add(btn2);
		panel.add(Box.createVerticalStrut(10));


		JButton btn3 = new JButton("Boton 3");
		panel.add(btn3);
		panel.add(Box.createVerticalStrut(10));


		JButton btn4 = new JButton("Boton 4");
		panel.add(btn4);
		panel.add(Box.createVerticalStrut(10));


		return panel;
	}

	public JPanel panelAbajo() {
		JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 100, 20));


		JButton btnEditar = new JButton("Editar");
		panel.add(btnEditar);

		JButton btnAgregar = new JButton("Agregar");
		panel.add(btnAgregar);
		
		JButton btnEliminar = new JButton("Eliminar");
		panel.add(btnEliminar);

		
		
		
		return panel;
	}
}
