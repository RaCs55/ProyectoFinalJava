package util;

import java.sql.*;
import java.util.ArrayList;

public class BaseDatosController {
    private static final String URL = "jdbc:postgresql://localhost:5432/Proyecto";
    private String user = "postgres";
    private String password = "postgres";

    public boolean comprobarConexion(String user, String password) {
        try (Connection con = DriverManager.getConnection(URL, user, password)) {
            this.user = user;
            this.password = password;
            return true;
        } catch (SQLException e) {
            GestionErrores.mostrarError(GestionErrores.TipoError.CONEXION_BD, "No se ha podido hacer la conexion", null);
        }
        return false;
    }

    public Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, user, password);
        } catch (SQLException e) {
            GestionErrores.mostrarError(GestionErrores.TipoError.CONEXION_BD,
                    "No se ha podido establecer la conexión a la base de datos",
                    null
            );
            return null;
        }
    }


    public ArrayList<String> obtenerNombreColumnas(String nombreTabla) {
        ArrayList<String> nombres = new ArrayList<>();
        try (Connection con = getConnection()) {
            String sql = "SELECT * FROM " + nombreTabla;
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);
            ResultSetMetaData rsmd = rs.getMetaData();

            int totalColumnas = rsmd.getColumnCount();
            for (int i = 1; i <= totalColumnas; i++) {
                nombres.add(rsmd.getColumnName(i));
            }
            return nombres;

        } catch (SQLException e) {
            return null;
        }
    }


    public void actualizarCeldaTabla(String nombreTabla, String nombreColumna, String nombrePK, Object valorPK, Object nuevoValor) {
        try (Connection con = getConnection()) {
            String sql = "UPDATE " + nombreTabla + " SET " + nombreColumna + " = " + "?" + " WHERE " + nombrePK + "= ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setObject(1, nuevoValor);
            ps.setObject(2, valorPK);
            System.out.println(sql);
            ps.executeUpdate();
        } catch (SQLException e) {
            GestionErrores.mostrarError(GestionErrores.TipoError.CONSULTA_BD, "No se ha podido cambiar el dato", null);
        }
    }
}
