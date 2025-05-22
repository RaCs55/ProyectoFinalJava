package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import util.BaseDatosController;
import util.Navegador;

public class VentanaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textUser;
	private JTextField textPassword;

	/**
	 * Create the frame.
	 */
	public VentanaPrincipal() {


		setTitle("VentanaPrincipal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(450, 300);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 434, 261);
		contentPane.add(panel);
		panel.setLayout(null);

		textUser = new JTextField();
		textUser.setBounds(173, 95, 221, 20);
		panel.add(textUser);
		textUser.setColumns(10);

		textPassword = new JTextField();
		textPassword.setBounds(173, 142, 221, 20);
		panel.add(textPassword);
		textPassword.setColumns(10);

		JLabel lblNewLabel = new JLabel("USUARIO");
		lblNewLabel.setBounds(25, 98, 74, 14);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("CONTRASEÑA");
		lblNewLabel_1.setBounds(25, 145, 97, 14);
		panel.add(lblNewLabel_1);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(0, 0, 434, 70);
		panel.add(panel_1);
		panel_1.setLayout(null);

		//JLabel lblNewLabel_3 = new JLabel("");
		//lblNewLabel_3.setBounds(33, 0, 34, 70);
		//panel_1.add(lblNewLabel_3);
		//lblNewLabel_3.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/images/izquierda.png")));
		JLabel lblNewLabel_2 = new JLabel("LOS POLLOS HERMANOS");
		lblNewLabel_2.setBounds(0, 22, 434, 26);
		panel_1.add(lblNewLabel_2);
		lblNewLabel_2.setBackground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);

		//JLabel lblNewLabel_3_1 = new JLabel("");
		//lblNewLabel_3_1.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/images/derecha.png")));
		//lblNewLabel_3_1.setBounds(359, 0, 34, 70);
		//panel_1.add(lblNewLabel_3_1);

		JButton btnEnviar = new JButton("Enviar");
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String user = textUser.getText();
				String password = textPassword.getText();

				BaseDatosController gestor = new BaseDatosController();
				if (gestor.comprobarConexion(user, password)) {
					// Aqui luego tengo que agregar otra ventana
					if (!Navegador.isCreate("VentanaMenu")) {
						VentanaMenu ventanaMenu = new VentanaMenu();
						Navegador.agregarVentana(ventanaMenu);
					}

					Navegador.dispatcher("VentanaMenu", true);
					Navegador.dispatcher("VentanaPrincipal", false);

				} else {
					mostrarMensaje("Error", "El usuario indicado no existe", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnEnviar.setBounds(25, 203, 369, 31);
		panel.add(btnEnviar);
		//ImageIcon icon = new ImageIcon(getClass().getResource("/images/izquierda.png"));
		//JLabel label = new JLabel(icon);
	}

	private void mostrarMensaje(String titulo, String mensaje, int tipo) {
		JOptionPane.showMessageDialog(this, mensaje, titulo, tipo);
	}
}
