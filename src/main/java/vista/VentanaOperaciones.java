package vista;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controlador.GestionBaseDeDatos;

public class VentanaOperaciones extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private GestionBaseDeDatos gestion = new GestionBaseDeDatos();

	public VentanaOperaciones() {
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

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 584, 22);
		panel.add(menuBar);

		JMenu mnNewMenu = new JMenu("New menu");
		menuBar.add(mnNewMenu);

		JMenuItem mntmNewMenuItem = new JMenuItem("New menu item");
		mnNewMenu.add(mntmNewMenuItem);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 22, 584, 339);
		panel.add(scrollPane);

		Object[][] data = rellenarData("ALIMENTO");
		String[] nombresColumna = gestion.obtenerNombreColumnas("ALIMENTO").toArray(new String[0]);

		for (String n : nombresColumna) {
			System.out.println(n);
		}

		DefaultTableModel model = new DefaultTableModel(data, nombresColumna);
		table = new JTable(model);
		scrollPane.setViewportView(table);
	}

	public Object[][] rellenarData(String nombreTabla) {
		ArrayList<ArrayList<Object>> tabla = gestion.obtenerDatosTabla(nombreTabla);

		if (tabla != null) {

			int columnas = tabla.get(0).size();
			int filas = tabla.size();
 
			Object[][] data = new Object[filas][columnas];
			for (int i = 0; i < filas; i++) {
				for (int j = 0; j < columnas; j++) {
					data[i][j] = tabla.get(i).get(j);
				}
			}

			return data;
		}

		return null;

	}

}
