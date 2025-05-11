package vista;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controlador.Navegador;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout());
		
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 584, 361);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout());
		
		JPanel panelBoton = new JPanel();
		panelBoton.setLayout(new FlowLayout(FlowLayout.CENTER));
		contentPane.add(panelBoton, BorderLayout.SOUTH);
		
		JLabel lblTitulo = new JLabel("Panel de Administación");
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTitulo.setHorizontalAlignment(JLabel.CENTER);
		panel.add(lblTitulo, BorderLayout.NORTH);
		
		
		JButton btnGestionPersonal = new JButton("Gestión del Personal");
		btnGestionPersonal.setPreferredSize(new Dimension(150, 40));
		panelBoton.add(btnGestionPersonal);

		JButton btnGestionOperaciones = new JButton("Gestión de Operaciones");
		btnGestionOperaciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!Navegador.isCreate("VentanaOperaciones")) {
					VentanaOperaciones ventanaOperaciones = new VentanaOperaciones();
					Navegador.agregarVentana(ventanaOperaciones);
				}
				
				Navegador.dispatcher("VentanaOperaciones", true);
				Navegador.dispatcher("VentanaMenu", false);

			}
		});
		
		btnGestionOperaciones.setPreferredSize(new Dimension(150, 40));
		panelBoton.add(btnGestionOperaciones);
		
		JButton btnGestionLocal = new JButton("Gestión del Local");
		btnGestionLocal.setPreferredSize(new Dimension(150, 40));
		panelBoton.add(btnGestionLocal);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(VentanaMenu.class.getResource("/images/Los_Pollos_Hermanos_logo - copia.png")));
		
		lblNewLabel.setHorizontalAlignment(JLabel.CENTER);
		panel.add(lblNewLabel, BorderLayout.CENTER);
		

	}
}
