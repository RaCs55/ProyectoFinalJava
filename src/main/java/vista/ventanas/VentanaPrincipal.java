package vista.ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controlador.ControladorBD;
import controlador.Navegador;


public class VentanaPrincipal extends JFrame {
	private static final long serialVersionUID = 1L;

    private static final String TITULO_APP = "LOS POLLOS HERMANOS";
    private static final String RUTA_ICONO_IZQ = "/images/izquierda.png";
    private static final String RUTA_ICONO_DER = "/images/derecha.png";
    
    private JTextField campoUsuario;
    private JPasswordField campoContrasena;
    private final ControladorBD controladorBD = new ControladorBD();

    public VentanaPrincipal() {
        configurarVentana();
        inicializarComponentes();
    }

    private void configurarVentana() {
        setTitle("VentanaPrincipal");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(450, 300);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
    }

    private void inicializarComponentes() {
        JPanel panelPrincipal = new JPanel(new BorderLayout());
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panelPrincipal.setBackground(Color.WHITE);

        panelPrincipal.add(crearPanelCabecera(), BorderLayout.NORTH);
        
        // Panel central con formulario
        panelPrincipal.add(crearPanelFormulario(), BorderLayout.CENTER);
        
        // Panel inferior con botón
        panelPrincipal.add(crearPanelBoton(), BorderLayout.SOUTH);

        add(panelPrincipal);
    }

    private JPanel crearPanelCabecera() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(Color.WHITE);
        panel.setPreferredSize(new Dimension(0, 70));

        // Icono izquierdo
        JLabel iconoIzq = new JLabel(new ImageIcon(getClass().getResource(RUTA_ICONO_IZQ)));
        panel.add(iconoIzq, BorderLayout.WEST);

        // Título central
        JLabel titulo = new JLabel(TITULO_APP);
        titulo.setFont(new Font("Tahoma", Font.BOLD, 18));
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(titulo, BorderLayout.CENTER);

        // Icono derecho
        JLabel iconoDer = new JLabel(new ImageIcon(getClass().getResource(RUTA_ICONO_DER)));
        panel.add(iconoDer, BorderLayout.EAST);

        return panel;
    }

    private JPanel crearPanelFormulario() {
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.WHITE);

        // Campo usuario
        JLabel etiquetaUsuario = new JLabel("USUARIO:");
        etiquetaUsuario.setBounds(25, 20, 100, 20);
        panel.add(etiquetaUsuario);

        campoUsuario = new JTextField();
        campoUsuario.setBounds(150, 20, 250, 25);
        panel.add(campoUsuario);

        // Campo contraseña
        JLabel etiquetaContrasena = new JLabel("CONTRASEÑA:");
        etiquetaContrasena.setBounds(25, 60, 100, 20);
        panel.add(etiquetaContrasena);

        campoContrasena = new JPasswordField();
        campoContrasena.setBounds(150, 60, 250, 25);
        panel.add(campoContrasena);

        return panel;
    }

    private JPanel crearPanelBoton() {
        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);

        JButton btnLogin = new JButton("Iniciar Sesión");
        btnLogin.setPreferredSize(new Dimension(300, 35));
        btnLogin.addActionListener(e -> manejarLogin());
        panel.add(btnLogin);

        return panel;
    }

    private void manejarLogin() {
        String usuario = campoUsuario.getText();
        String contrasena = new String(campoContrasena.getPassword());

        if (controladorBD.comprobarConexion(usuario, contrasena)) {
        	if (!Navegador.isCreate("VentanaMenu")) {
        		VentanaMenu ventanaMenu = new VentanaMenu();
        		Navegador.agregarVentana(ventanaMenu);
        	}
            Navegador.dispatcher("VentanaMenu", true);
            Navegador.dispatcher("VentanaPrincipal", false);
        } else {
            mostrarErrorAutenticacion();
        }
    }

    private void mostrarErrorAutenticacion() {
        JOptionPane.showMessageDialog(
            this, 
            "Credenciales incorrectas", 
            "Error de autenticación", 
            JOptionPane.ERROR_MESSAGE
        );
        
        campoUsuario.setText("");
        campoContrasena.setText("");
        campoUsuario.requestFocus();
    }
}