package vista;

import controlador.*;
import modelo.*;
import util.BaseDatosController;
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
    private Map<String, JTextField> textFieldsMap = new HashMap<>();
    private Pedir pedir;


    public VentanaAgregar(String nombreTabla, JTable table, Pedir pedir) {
        this.nombreTabla = nombreTabla;
        this.pedir = pedir;

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

        System.out.println(pedir.getCodFactura());
        System.out.println(pedir.getCodPedido());
        JPanel camposPanel = getCamposPanel();
        getContentPane().add(camposPanel, BorderLayout.CENTER);


        JButton btnGuardar = new JButton("Guardar");
        JPanel botonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        botonPanel.add(btnGuardar);
        getContentPane().add(botonPanel, BorderLayout.SOUTH);

        btnGuardar.addActionListener(e -> {
            if (!isSomeTextFieldEmpty()) {
                agregarTablaPorNombre();
                TablasController tablasController = new TablasController(table);
                tablasController.actualizarTabla(nombreTabla);
                dispose();
            } else {
                System.out.println("ERROR");
            }
        });

    }

    public JPanel getCamposPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        BaseDatosController baseDatosController = new BaseDatosController();
        List<String> columnas = baseDatosController.obtenerNombreColumnas(nombreTabla);

        for (String columna : columnas) {
            JPanel fila = new JPanel(new FlowLayout(FlowLayout.CENTER));

            JLabel label = new JLabel(columna + ":");
            label.setPreferredSize(new Dimension(120, 25));
            JTextField textField = new JTextField(20);

            labelsMap.put(columna, label);
            textFieldsMap.put(columna, textField);

            fila.add(label);
            fila.add(textField);

            panel.add(fila);
        }

        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        return panel;
    }


    public boolean isSomeTextFieldEmpty() {

        for (JTextField textField : textFieldsMap.values()) {
            if (textField.getText().isEmpty()) {
                return true;
            }
        }

        return false;
    }

    public void agregarTablaPorNombre() {
        switch (nombreTabla) {
            case "Pedido":
                PedidoController.agregar(crearPedido());

                if (pedir.getCodFactura() != null && pedir.getCodPedido() != null) {
                    PedirController.agregar(crearPedir());
                    pedir.setCodPedido(null);
                    pedir.setCodFactura(null);
                }
                break;
            case "Producto":
                ProductoController.agregar(crearProducto());
                break;
            case "Trabajador":
                TrabajadorController.agregar(crearTrabjador());
                break;
            case "Factura":
                FacturaController.agregar(crearFactura());
                if (pedir.getCodPedido() != null && pedir.getCodFactura() != null) {
                    System.out.println("H");
                    PedirController.agregar(crearPedir());
                    pedir.setCodPedido(null);
                    pedir.setCodFactura(null);
                }
                break;
            case "Proveedor":
                ProveedorController.agregar(crearProveedor());
                break;
            default:

                break;

        }
    }

    private Pedir crearPedir() {
        return new Pedir(
                pedir.getCodPedido(),
                pedir.getCodFactura()
        );
    }

    private Proveedor crearProveedor() {
        return new Proveedor(
                textFieldsMap.get("cifProveedor").getText(),
                textFieldsMap.get("nombre").getText(),
                textFieldsMap.get("direccion").getText()
        );
    }


    public Pedido crearPedido() {
        pedir.setCodPedido(textFieldsMap.get("codpedido").getText());
        return new Pedido(
                textFieldsMap.get("codpedido").getText(),
                textFieldsMap.get("comida").getText(),
                textFieldsMap.get("bebida").getText()
        );
    }

    public Trabajador crearTrabjador() {

        return new Trabajador(
                textFieldsMap.get("dni").getText(),
                textFieldsMap.get("nombre").getText(),
                textFieldsMap.get("apellidos").getText(),
                Integer.parseInt(textFieldsMap.get("anyos_experiencia").getText())
        );
    }


    public Producto crearProducto() {
        return new Producto(
                textFieldsMap.get("codProducto").getText(),
                textFieldsMap.get("nombre").getText(),
                textFieldsMap.get("tipo").getText(),
                Double.parseDouble(textFieldsMap.get("precio").getText())
        );
    }

    public Factura crearFactura() {
        pedir.setCodFactura(textFieldsMap.get("codfactura").getText());
        return new Factura(
                textFieldsMap.get("codfactura").getText(),
                textFieldsMap.get("forma_de_pago").getText(),
                Double.parseDouble(textFieldsMap.get("precio_total").getText())
        );
    }


}
