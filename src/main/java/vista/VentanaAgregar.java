package vista;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controlador.ControladorBD;
import controlador.ControladorTablas;
import controlador.Navegador;
import modelo.dao.AlimentoDAO;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaAgregar extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private ArrayList<JTextField> camposTexto = new ArrayList<JTextField>();
	private ControladorTablas controladorTablas;

	public VentanaAgregar(String nombreTabla, String nombreVentanaProveniente, JTable tabla) {
		controladorTablas = new ControladorTablas(tabla);

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				Navegador.dispatcher(nombreVentanaProveniente, true);
				controladorTablas.actualizarTabla(nombreTabla);
			}
		});
		setTitle("VentanaAgregar");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));

		panel.setLayout(null);
		setContentPane(panel);
		

		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				switch (nombreTabla) {
				case "ALIMENTO":
	
					break;

				default:
					break;
				}

			}
		});
		btnAceptar.setBounds(169, 227, 89, 23);
		panel.add(btnAceptar);

		ControladorBD gestion = new ControladorBD();
		String[] nombresColumnas = gestion.obtenerNombreColumnas(nombreTabla).toArray(new String[0]);

		numeroLabels(nombresColumnas);

	}

	public void numeroLabels(String[] nombresLabels) {
		int y = 20;

		for (String nombre : nombresLabels) {
			JLabel lbl = new JLabel(nombre + ":");
			lbl.setBounds(20, y, 80, 20);
			panel.add(lbl);

			JTextField txt = new JTextField();
			txt.setBounds(110, y, 250, 20);
			panel.add(txt);
			camposTexto.add(txt);
			y += 30;
		}
	}

	public ArrayList<String> obtenerDatosTextFields() {
		ArrayList<String> datos = new ArrayList<String>();

		for (JTextField campo : camposTexto) {
			datos.add(campo.getText());
		}

		return datos;
	}

}