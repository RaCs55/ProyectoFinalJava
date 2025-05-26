package vista.ventanas;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controlador.ControladorBD;
import controlador.ControladorTablas;
import controlador.Navegador;

public class VentanaMenu extends JFrame {
	private static final long serialVersionUID = 1L;

    private static final String TITULO = "Panel de Administración";
    private static final String RUTA_LOGO = "/images/Los_Pollos_Hermanos_logo.png";
    
    public VentanaMenu() {
        configurarVentana();
        inicializarComponentes();
    }

    private void configurarVentana() {
        setTitle("VentanaMenu");
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
    }

    private void inicializarComponentes() {
        // Panel principal
        JPanel panelPrincipal = new JPanel(new BorderLayout());
        
        // Panel superior con título
        panelPrincipal.add(crearPanelTitulo(), BorderLayout.NORTH);
        
        // Panel central con logo
        panelPrincipal.add(crearPanelLogo(), BorderLayout.CENTER);
        
        // Panel inferior con botones
        panelPrincipal.add(crearPanelBotones(), BorderLayout.SOUTH);
        
        add(panelPrincipal);
    }

    private JPanel crearPanelTitulo() {
        JPanel panel = new JPanel();
        JLabel titulo = new JLabel(TITULO);
        titulo.setFont(new Font("Tahoma", Font.PLAIN, 20));
        panel.add(titulo);
        return panel;
    }

    private JPanel crearPanelLogo() {
        JPanel panel = new JPanel(new BorderLayout());
        ImageIcon icono = new ImageIcon(getClass().getResource(RUTA_LOGO));
        JLabel logo = new JLabel(icono);
        logo.setHorizontalAlignment(JLabel.CENTER);
        panel.add(logo, BorderLayout.CENTER);
        return panel;
    }

    private JPanel crearPanelBotones() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        
        agregarBoton(panel, "Gestión del Personal", "VentanaPersonal");
        agregarBoton(panel, "Gestión de Operaciones", "VentanaOperaciones");
        agregarBoton(panel, "Gestión del Local", "VentanaLocal");
        
        return panel;
    }

    private void agregarBoton(JPanel panel, String textoBoton, String destinoVentana) {
        JButton boton = new JButton(textoBoton);
        boton.setPreferredSize(new Dimension(180, 40));
        boton.addActionListener(e -> manejarClicBoton(destinoVentana));
        panel.add(boton);
    }

    private void manejarClicBoton(String destinoVentana) {
    	
    	if (!Navegador.isCreate(destinoVentana)) {
    		switch (destinoVentana) {
			case "VentanaLocal":
				VentanaLocal ventanaLocal = new VentanaLocal(new ControladorTablas());
				Navegador.agregarVentana(ventanaLocal);
				break;
			case "VentanaOperaciones":
				VentanaOperaciones ventanaOperaciones= new VentanaOperaciones(new ControladorTablas());
				Navegador.agregarVentana(ventanaOperaciones);
			case "VentanaPersonal":
				VentanaPersonal ventanaPersonal = new VentanaPersonal(new ControladorTablas());
				Navegador.agregarVentana(ventanaPersonal);
			default:
				break;
			}
    	}
        Navegador.dispatcher(destinoVentana, true);
        Navegador.dispatcher(getTitle(), false);
    }
}