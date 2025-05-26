package vista;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.*;

import controlador.*;
import modelo.Pedir;
import util.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaMenu extends JFrame {

    private static final long serialVersionUID = 1L;
    private JTable table;
    private String nombreTablaActual;
    private TablasController tablasController;
    private Map<String, JButton> botonesMapTablas = new HashMap<>();
    private Map<String, JButton> botonesMapFunciones = new HashMap<>();
    FileController fileController = new FileController();

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

        JMenu mnFile = new JMenu("File");
        menuBar.add(mnFile);

        JMenuItem mntmImportar = new JMenuItem("Importar");
        mntmImportar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String ruta = fileController.elegirRuta();
                ArrayList<String[]> datos = fileController.cargarDatos(ruta);
                GestionArchivos.importarArchivo(ruta, datos, nombreTablaActual);

                tablasController.actualizarTabla(nombreTablaActual);
            }
        });
        mnFile.add(mntmImportar);

        JMenuItem mntmExportar = new JMenuItem("Exportar");
        mnFile.add(mntmExportar);
        mntmExportar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ruta = fileController.elegirRuta();
                GestionArchivos.exportarArchivo(ruta, nombreTablaActual);
            }
        });

        tablasController = new TablasController(table);

        controlBotonesTablas();
        controlBotonesFunciones();

    }


    public JPanel panelArriba() {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        JLabel titulo = new JLabel("LOS POLLOS HERMANOS");
        titulo.setFont(new Font("SansSerif", Font.PLAIN, 24));
        panel.add(titulo);

        return panel;
    }

    public JPanel panelCentral() {
        JPanel panel = new JPanel(new BorderLayout());
        JScrollPane scrollPane = new JScrollPane();
        table = new JTable();

        scrollPane.setViewportView(table);
        panel.add(scrollPane, BorderLayout.CENTER);

        return panel;
    }

    public JPanel panelIzquierda() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        Dimension buttonSize = new Dimension(120, 30);
        int strutSize = 15;

        String[] buttonNames = {"Producto", "Proveedor", "Factura", "Pedido", "Trabajador"};

        for (String name : buttonNames) {
            JButton button = new JButton(name);
            button.setMaximumSize(buttonSize);
            button.setAlignmentX(Component.CENTER_ALIGNMENT);
            botonesMapTablas.put(name, button);
            panel.add(button);
            panel.add(Box.createVerticalStrut(strutSize));
        }

        return panel;
    }

    public JPanel panelAbajo() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 100, 20));

        String[] buttonNames = {"Editar", "Agregar", "Eliminar"};

        for (String name : buttonNames) {
            JButton button = new JButton(name);
            button.setAlignmentX(Component.CENTER_ALIGNMENT);
            botonesMapFunciones.put(name, button);
            panel.add(button);
        }


        return panel;
    }

    public void controlBotonesTablas() {

        for (String button : botonesMapTablas.keySet()) {
            botonesMapTablas.get(button).addActionListener(e -> {
                        nombreTablaActual = button;
                        tablasController.actualizarTabla(nombreTablaActual);
                    }
            );
        }
    }

    public void controlBotonesFunciones() {

        for (String button : botonesMapFunciones.keySet()) {

            botonesMapFunciones.get(button).addActionListener(e -> {
                switch (button) {
                    case "Editar":
                        tablasController.setEsEditable(!tablasController.getEsEditable());
                        String valor = tablasController.getEsEditable() ? "si" : "no";
                        String mensaje = "Ahora las tablas " + valor + " se pueden editar.";
                        GestionErrores.mostrarMensaje(mensaje, "Editar", this);
                        tablasController.actualizarTabla(nombreTablaActual);
                        break;
                    case "Agregar":
                        System.out.println(nombreTablaActual);
                        VentanaAgregar ventanaAgregar = new VentanaAgregar(nombreTablaActual, table);
                        ventanaAgregar.setVisible(true);
                        break;
                    case "Eliminar":
                        int column = 0;
                        int row = table.getSelectedRow();
                        String value = table.getModel().getValueAt(row, column).toString();
                        eliminarFila(value);
                }
                tablasController.actualizarTabla(nombreTablaActual);

            });
        }
    }

    public void eliminarFila(String codigo) {
        switch (nombreTablaActual) {
            case "Proveedor":
                ProveedorController.eliminar(codigo);
                break;
            case "Producto":
                ProductoController.eliminar(codigo);
                break;
            case "Trabajador":
                TrabajadorController.eliminar(codigo);
                break;
            case "Factura":
                FacturaController.eliminar(codigo);
                break;
            case "Pedido":
                PedidoController.eliminar(codigo);
                break;
        }
    }
}
