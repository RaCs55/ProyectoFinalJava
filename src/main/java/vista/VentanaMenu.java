package vista;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.Navegador;

public class VentanaMenu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public VentanaMenu() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				Navegador.dispatcher("VentanaPrincipal", true);
			}
		});
		setTitle("VentanaMenu");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
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
	}
}
