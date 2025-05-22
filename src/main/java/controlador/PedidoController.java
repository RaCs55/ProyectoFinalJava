package controlador;

import modelo.Pedido;
import modelo.Producto;
import modelo.Trabajador;
import modelo.dao.PedidoDAO;

import java.sql.SQLException;
import java.util.ArrayList;

public class PedidoController {
    private static PedidoDAO pedidoDAO = new PedidoDAO();

    public static void agregar(Pedido pedido) {
        try {
            pedidoDAO.agregar(pedido);
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void eliminar(String codigo) {
        try {
            pedidoDAO.eliminar(codigo);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Pedido crearPedidoDesdeArray(String[] datos) {
        return new Pedido(datos[0], datos[1], datos[2]);
    }

    public static Pedido[] pasarArchivoAPedido(ArrayList<String[]> datos) {
        Pedido[] pedidosArchivo = new Pedido[datos.size()];
        for (int i = 0; i < pedidosArchivo.length; i++) {
            pedidosArchivo[i] = crearPedidoDesdeArray(datos.get(i));
        }
        return pedidosArchivo;
    }

    public static void agregarTodosLosValores(Pedido[] pedidos) {
        for (int i = 0; i < pedidos.length; i++) {
            agregar(pedidos[i]);
        }
    }

    public static Pedido[] obtenerPedidos() {
        try {
            Pedido[] pedidos = pedidoDAO.mostrar();
            return pedidos;
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Object[][] obtenerValores() {
        Pedido[] pedidos = obtenerPedidos();
        Object[][] data = new Object[pedidos.length][3];
        for (int i = 0; i < pedidos.length; i++) {
            data[i][0] = pedidos[i].getCodPedido();
            data[i][1] = pedidos[i].getComida();
            data[i][2] = pedidos[i].getBebida();
        }

        return data;

    }
}
