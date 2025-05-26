package controlador;

import modelo.Producto;
import modelo.Proveedor;
import modelo.dao.ProductoDAO;
import util.FileController;
import util.GestionErrores;

import java.sql.SQLException;
import java.util.ArrayList;

public class ProductoController {
    private static ProductoDAO productoDAO = new ProductoDAO();

    public static void agregar(Producto producto) {
        try {
            productoDAO.agregar(producto);
        }catch (SQLException e) {
            GestionErrores.manejarSQLException(e, null);
        }
    }

    public static void eliminar(String codigo) {
        try {
            productoDAO.eliminar(codigo);
        }catch (SQLException e) {
            GestionErrores.manejarSQLException(e, null);
        }
    }

    public static Producto crearProductoDesdeArray(String[] datos) {
        return new Producto(datos[0], datos[1], datos[2], Double.parseDouble(datos[3]));
    }

    public static Producto[] pasarArchivoAProducto(ArrayList<String[]> datos) {
        Producto[] productosArchivo = new Producto[datos.size()];
        for (int i = 0; i < productosArchivo.length; i++) {
            productosArchivo[i] = crearProductoDesdeArray(datos.get(i));
        }
        return productosArchivo;
    }

    public static void agregarTodosLosValores(Producto[] productos) {
        for (int i = 0; i < productos.length; i++) {
            agregar(productos[i]);
        }
    }

    public static Producto[] obtenerProductos() {
        try {
            Producto[] productos = productoDAO.mostrar();
            return productos;
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Object[][] obtenerValores() {
        Producto[] productos = obtenerProductos();
        Object[][] data = new Object[productos.length][4];
        for (int i = 0; i < productos.length; i++) {
            data[i][0] = productos[i].getCodProducto();
            data[i][1] = productos[i].getNombre();
            data[i][2] = productos[i].getTipo();
            data[i][3] = productos[i].getPrecio();
        }

        return data;

    }

    public static String[] obtenerNombreProductos() {
        try {
            return productoDAO.obtenerNombreProducto();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String[] obtenerBebidasProductos() {
        try {
            return productoDAO.obtenerBebidasProducto();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }





}
