package controlador;

import modelo.Pedir;
import modelo.dao.PedirDAO;
import util.GestionErrores;

import java.sql.SQLException;

public class PedirController {
    private static PedirDAO pedirDAO = new PedirDAO();

    public static void agregar(Pedir pedir) {
        try {
            pedirDAO.agregar(pedir);
        }catch (SQLException e) {
            GestionErrores.manejarSQLException(e, null);
        }
    }

    public static void eliminar(String codigo) {
        try {
            pedirDAO.eliminar(codigo);
        } catch (SQLException e) {
            GestionErrores.manejarSQLException(e, null);
        }
    }
}
