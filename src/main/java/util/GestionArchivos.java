package util;

import controlador.*;
import modelo.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class GestionArchivos {
    public static void importarArchivo(String ruta, ArrayList<String[]> datos, String nombreTabla) {
        switch (nombreTabla) {
            case "Producto":
                Producto[] productos = ProductoController.pasarArchivoAProducto(datos);
                ProductoController.agregarTodosLosValores(productos);
                break;
            case "Proveedor":
                Proveedor[] proveedores = ProveedorController.pasarArchivoAProveedor(datos);
                ProveedorController.agregarTodosLosValores(proveedores);
                break;
            case "Pedido":
                Pedido[] pedidos = PedidoController.pasarArchivoAPedido(datos);
                PedidoController.agregarTodosLosValores(pedidos);
                break;
            case "Factura":
                Factura[] facturas = FacturaController.pasarArchivoAFactura(datos);
                FacturaController.agregarTodosLosValores(facturas);
                break;
            case "Trabajador":
                Trabajador[] trabajadores = TrabajadorController.pasarArchivoATrabajador(datos);
                TrabajadorController.agregarTodosLosValores(trabajadores);
                break;
        }
    }


    public static Object[] obtenerDatosTabla(String nombreTabla) {
        Object[] datos = null;
        switch (nombreTabla) {
            case "Producto":
                datos = ProductoController.obtenerProductos();
                break;
            case "Proveedor":
                datos = ProveedorController.obtenerProveedores();
                break;
            case "Pedido":
                datos = PedidoController.obtenerPedidos();
                break;
            case "Factura":
                datos = FacturaController.obtenerFacturas();
                break;
            case "Trabajador":
                datos = TrabajadorController.obtenerTrabajadores();
                break;
        }

        return datos;
    }

    public static void exportarArchivo(String ruta, String nombreTabla) {
        if (ruta != null) {
            File f = new File(ruta);

            FileWriter fw;
            BufferedWriter bw;

            try {
                fw = new FileWriter(f, true);
                bw = new BufferedWriter(fw);
                Object[] datos = obtenerDatosTabla(nombreTabla);
                for (Object o : datos) {
                    bw.write(o.toString());
                    bw.newLine();
                }
                bw.flush();
                bw.close();
            } catch (IOException ex) {
                GestionErrores.mostrarError(GestionErrores.TipoError.DATOS_INVALIDOS, "No se ha podido escribir en el archivo", null);
            }
        }
    }
}
