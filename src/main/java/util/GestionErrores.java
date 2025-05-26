package util;

import javax.swing.*;
import java.sql.SQLException;

public class GestionErrores {

    public enum TipoError {
        CONEXION_BD,
        ARCHIVO,
        DATOS_INVALIDOS,
        OPERACION_NO_COMPLETADA,
        CONSULTA_BD,
        VALIDACION
    }

    public static void mostrarError(TipoError tipo, String mensajeAdicional, JFrame jFrame) {
        String titulo = "Error";
        String mensaje = "";

        switch(tipo) {
            case CONEXION_BD:
                mensaje = "Error de conexión con la base de datos.\n" + mensajeAdicional;
                break;
            case CONSULTA_BD:
                mensaje = "Error al ejecutar consulta en la base de datos.\n" + mensajeAdicional;
                break;
            case DATOS_INVALIDOS:
                mensaje = "Datos inválidos ingresados.\n" + mensajeAdicional;
                titulo = "Validación";
                break;
            case OPERACION_NO_COMPLETADA:
                mensaje = "No se pudo completar la operación.\n" + mensajeAdicional;
                break;
            case ARCHIVO:
                mensaje = "Error al manejar archivos.\n" + mensajeAdicional;
                break;
            case VALIDACION:
                mensaje = mensajeAdicional;
                titulo = "Validación";
                break;
        }

        JOptionPane.showMessageDialog(jFrame, mensaje, titulo, JOptionPane.ERROR_MESSAGE);
    }

    public static void manejarSQLException(SQLException ex, JFrame jFrame) {
        String mensaje = "Error SQL: " + ex.getMessage() +
                "\nCodigo de error: " + ex.getErrorCode() +
                "\nEstado SQL: " + ex.getSQLState();

        mostrarError(TipoError.CONSULTA_BD, mensaje, jFrame);
    }

    public static void mostrarMensaje(String mensaje, String titulo, JFrame jFrame) {
        JOptionPane.showMessageDialog(jFrame, mensaje, titulo, JOptionPane.INFORMATION_MESSAGE);
    }



}
