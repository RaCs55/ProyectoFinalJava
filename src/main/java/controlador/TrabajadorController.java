package controlador;

import modelo.Producto;
import modelo.Proveedor;
import modelo.Trabajador;
import modelo.dao.TrabajadorDAO;
import util.GestionErrores;

import java.sql.SQLException;
import java.util.ArrayList;

public class TrabajadorController {
    private static TrabajadorDAO trabajadorDAO = new TrabajadorDAO();



    public static void agregar(Trabajador trabajador) {
        try {
            trabajadorDAO.agregar(trabajador);
        }catch (SQLException e) {
            GestionErrores.manejarSQLException(e, null);
        }
    }

    public static void eliminar(String codigo) {
        try {
            trabajadorDAO.eliminar(codigo);
        } catch (SQLException e) {
            GestionErrores.manejarSQLException(e, null);
        }
    }


    public static Trabajador crearTrabajadorDesdeArray(String[] datos) {
        return new Trabajador(datos[0], datos[1], datos[2], Integer.parseInt(datos[3]));
    }

    public static Trabajador[] pasarArchivoATrabajador(ArrayList<String[]> datos) {
        Trabajador[] trabajadoresArchivo = new Trabajador[datos.size()];
        for (int i = 0; i < trabajadoresArchivo.length; i++) {
            trabajadoresArchivo[i] = crearTrabajadorDesdeArray(datos.get(i));
        }
        return trabajadoresArchivo;
    }

    public static void agregarTodosLosValores(Trabajador[] trabajadores) {
        for (int i = 0; i < trabajadores.length; i++) {
            agregar(trabajadores[i]);
        }
    }

    public static Trabajador[] obtenerTrabajadores() {
        try {
            Trabajador[] trabajadores = trabajadorDAO.mostrar();
            return trabajadores;
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Object[][] obtenerValores() {
        Trabajador[] trabajadores = obtenerTrabajadores();
        Object[][] data = new Object[trabajadores.length][4];
        for (int i = 0; i < trabajadores.length; i++) {
            data[i][0] = trabajadores[i].getDni();
            data[i][1] = trabajadores[i].getNombre();
            data[i][2] = trabajadores[i].getApellidos();
            data[i][3] = trabajadores[i].getAnyosExperiencia();
        }

        return data;

    }

}
