package vista;

import controlador.*;
import modelo.*;
import util.BaseDatosController;
import util.GestionErrores;
import util.Navegador;
import util.TablasController;


import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.*;


public class VentanaAgregar extends JFrame {

    private static final long serialVersionUID = 1L;
    private String nombreTabla;
    private Map<String, JLabel> labelsMap = new HashMap<>();
    private Map<String, JComponent> componentesMap = new HashMap<>();


    public VentanaAgregar(String nombreTabla, JTable table) {
        this.nombreTabla = nombreTabla;

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                setVisible(false);
                Navegador.dispatcher("VentanaMenu", true);
            }
        });

        setTitle("VentanaAgregar");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(450, 300);
        setLocationRelativeTo(null);

        getContentPane().setLayout(new BorderLayout());


        JPanel camposPanel = getCamposPanel(nombreTabla);
        getContentPane().add(camposPanel, BorderLayout.CENTER);


        JButton btnGuardar = new JButton("Guardar");
        JPanel botonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        botonPanel.add(btnGuardar);
        getContentPane().add(botonPanel, BorderLayout.SOUTH);

        btnGuardar.addActionListener(e -> {
            if (!hayAlgunTextFieldVacio()) {
                agregarTablaPorNombre();
                TablasController tablasController = new TablasController(table);
                tablasController.actualizarTabla(nombreTabla);
                dispose();
            } else {
                GestionErrores.mostrarError(GestionErrores.TipoError.OPERACION_NO_COMPLETADA,
                        "Tienen que estar que rellenar todos los campos", this);
           }
        });

    }

    private JPanel crearCampo(String nombreCampo) {
        JPanel fila = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel label = new JLabel(nombreCampo + ":");
        label.setPreferredSize(new Dimension(120, 25));
        JTextField textField = new JTextField(20);

        labelsMap.put(nombreCampo, label);
        componentesMap.put(nombreCampo, textField);

        fila.add(label);
        fila.add(textField);
        return fila;
    }

    private JPanel crearCampoCombo(String nombreCampo, String[] opciones) {
        JPanel fila = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel label = new JLabel(nombreCampo + ":");
        label.setPreferredSize(new Dimension(150, 25));
        JComboBox<String> comboBox = new JComboBox<>(opciones);
        comboBox.setPreferredSize(new Dimension(200, 25));

        labelsMap.put(nombreCampo, label);
        componentesMap.put(nombreCampo, comboBox);

        fila.add(label);
        fila.add(comboBox);
        return fila;
    }

    public JPanel getCamposPanel(String nombreTabla) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        String[] formasDePago = {"Tarjeta", "Efectivo"};

        switch (nombreTabla) {
            case "Trabajador":
                panel.add(crearCampo("dni"));
                panel.add(crearCampo("nombre"));
                panel.add(crearCampo("apellidos"));
                panel.add(crearCampo("anyos_experiencia"));
                break;
            case "Proveedor":
                panel.add(crearCampo("cifProveedor"));
                panel.add(crearCampo("nombre"));
                panel.add(crearCampo("direccion"));
                break;
            case "Pedido":
                String[] nombresProductos = ProductoController.obtenerNombreProductos();
                String[] bebidasProductos = ProductoController.obtenerBebidasProductos();

                panel.add(crearCampoCombo("nombre", nombresProductos));
                panel.add(crearCampoCombo("bebida", bebidasProductos));
                panel.add(crearCampoCombo("forma_de_pago", formasDePago));
                break;
            case "Producto":
                String[] tiposProductos = {"Menu", "Entrante", "Postre", "Bebida"};
                panel.add(crearCampo("nombre"));
                panel.add(crearCampoCombo("tipo", tiposProductos));
                panel.add(crearCampo("precio"));
                break;
            case "Factura":
                panel.add(crearCampoCombo("forma_de_pago", formasDePago));
                panel.add(crearCampo("precio_total"));
                break;
        }

        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        return panel;
    }


    private String getValorCampo(String nombreCampo) {
        JComponent comp = componentesMap.get(nombreCampo);
        if (comp instanceof JTextField) {
            return ((JTextField)comp).getText();
        } else if (comp instanceof JComboBox) {
            return (String) ((JComboBox<String>) comp).getSelectedItem();
        }
        return null;
    }

    public boolean hayAlgunTextFieldVacio() {
        for (JComponent componente : componentesMap.values()) {
            if (componente instanceof JTextField) {
                JTextField tf = (JTextField) componente;
                if (tf.getText().isEmpty()) {
                    return true;
                }
            } else if (componente instanceof JComboBox) {
                JComboBox<String> cb = (JComboBox<String>) componente;
                if (cb.getSelectedItem() == null || cb.getSelectedItem().toString().isEmpty()) {
                    return true;
                }
            }
        }
        return false;
    }

    public void agregarTablaPorNombre() {
        switch (nombreTabla) {
            case "Pedido":
                PedidoController.agregar(crearPedido());
                break;
            case "Producto":
                ProductoController.agregar(crearProducto());
                break;
            case "Trabajador":
                TrabajadorController.agregar(crearTrabjador());
                break;
            case "Factura":
                FacturaController.agregar(crearFactura());
                break;
            case "Proveedor":
                ProveedorController.agregar(crearProveedor());
                break;
        }
    }




    private Proveedor crearProveedor() {
        return new Proveedor(
                getValorCampo("cifProveedor"),
                getValorCampo("nombre"),
                getValorCampo("direccion")
        );
    }


    public Pedido crearPedido() {
        return new Pedido(
                null,
                getValorCampo("nombre"),
                getValorCampo("bebida"),
                getValorCampo("forma_de_pago")
        );
    }

    public Trabajador crearTrabjador() {
        return new Trabajador(
                getValorCampo("dni"),
                getValorCampo("nombre"),
                getValorCampo("apellidos"),
                Integer.parseInt(getValorCampo("anyos_experiencia"))
        );
    }


    public Producto crearProducto() {
        return new Producto(
                null,
                getValorCampo("nombre"),
                getValorCampo("tipo"),
                Double.parseDouble(getValorCampo("precio"))
        );
    }

    public Factura crearFactura() {
        return new Factura(
                null,
                getValorCampo("forma_de_pago"),
                Double.parseDouble(getValorCampo("precio_total"))
        );
    }


}
