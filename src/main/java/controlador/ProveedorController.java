package controlador;

import modelo.Producto;
import modelo.Proveedor;
import modelo.dao.ProductoDAO;
import modelo.dao.ProveedorDAO;

import java.sql.SQLException;
import java.util.ArrayList;

public class ProveedorController {
    private static ProveedorDAO proveedorDAO = new ProveedorDAO();

    public static void agregar(Proveedor proveedor) {
        try {
            proveedorDAO.agregar(proveedor);
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static void eliminar(String codigo) {
        try {
            proveedorDAO.eliminar(codigo);
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void borrarContenido() {
        try {
            proveedorDAO.borrarContenido();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Proveedor crearProveedorDesdeArray(String[] datos) {
        return new Proveedor(datos[0], datos[1], datos[2]);
    }

    public static Proveedor[] pasarArchivoAProveedor(ArrayList<String[]> datos) {
        Proveedor[] proveedoresArchivo = new Proveedor[datos.size()];
        for (int i = 0; i < proveedoresArchivo.length; i++) {
            proveedoresArchivo[i] = crearProveedorDesdeArray(datos.get(i));
        }
        return proveedoresArchivo;
    }

    public static void agregarTodosLosValores(Proveedor[] proveedores) {
        for (int i = 0; i < proveedores.length; i++) {
            agregar(proveedores[i]);
        }
    }

    public static Proveedor[] obtenerProveedores() {
        try {
            Proveedor[] proveedores = proveedorDAO.mostrar();
            return proveedores;
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Object[][] obtenerValores() {
        Proveedor[] proveedores = obtenerProveedores();
        Object[][] data = new Object[proveedores.length][3];
        for (int i = 0; i < proveedores.length; i++) {
            data[i][0] = proveedores[i].getCifProveedor();
            data[i][1] = proveedores[i].getNombre();
            data[i][2] = proveedores[i].getDireccion();
        }

        return data;

    }
}
