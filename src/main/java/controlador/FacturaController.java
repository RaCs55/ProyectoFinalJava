package controlador;

import modelo.Factura;
import modelo.Pedido;
import modelo.Producto;
import modelo.dao.FacturaDAO;
import modelo.dao.ProductoDAO;
import util.GestionErrores;

import java.sql.SQLException;
import java.util.ArrayList;

public class FacturaController {
    private static FacturaDAO facturaDAO = new FacturaDAO();


    public static void agregar(Factura factura) {
        try {
            facturaDAO.agregar(factura);
        }catch (SQLException e) {
            GestionErrores.manejarSQLException(e, null);
        }
    }

    public static void eliminar(String codigo) {
        try {
            facturaDAO.eliminar(codigo);
        } catch (SQLException e) {
            GestionErrores.manejarSQLException(e, null);
        }
    }

    public static Factura crearFacturaDesdeArray(String[] datos) {
        return new Factura(datos[0], datos[1], Double.parseDouble(datos[2]));
    }

    public static Factura[] pasarArchivoAFactura(ArrayList<String[]> datos) {
        Factura[] facturasArchivo = new Factura[datos.size()];
        for (int i = 0; i < facturasArchivo.length; i++) {
            facturasArchivo[i] = crearFacturaDesdeArray(datos.get(i));
        }
        return facturasArchivo;
    }

    public static void agregarTodosLosValores(Factura[] facturas) {
        for (int i = 0; i < facturas.length; i++) {
            agregar(facturas[i]);
        }
    }

    public static Factura[] obtenerFacturas() {
        try {
            Factura[] facturas = facturaDAO.mostrar();
            return facturas;
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static Object[][] obtenerValores() {
        Factura[] facturas = obtenerFacturas();
        Object[][] data = new Object[facturas.length][3];
        for (int i = 0; i < facturas.length; i++) {
            data[i][0] = facturas[i].getCodFactura();
            data[i][1] = facturas[i].getFormaPago();
            data[i][2] = facturas[i].getPrecioTotal();
        }

        return data;

    }
}
