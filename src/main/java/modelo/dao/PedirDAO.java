package modelo.dao;

import modelo.Pedir;

import java.sql.*;
import java.util.ArrayList;

public class PedirDAO extends ModeloDAO<Pedir, String>{
    @Override
    public boolean agregar(Pedir pedir) throws SQLException {
        try (Connection con = DriverManager.getConnection(url, user, password)) {
            String sql = "INSERT INTO PEDIR (codfactura, codpedido) VALUES (?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, pedir.getCodFactura());
            ps.setString(2, pedir.getCodPedido());
            ps.execute();
            return true;

        }

    }

    @Override
    public boolean eliminar(String codigo) throws SQLException {
        try (Connection con = DriverManager.getConnection(url, user, password)) {
            String sql = "DELETE FROM PEDIR WHERE codfactura = ?";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, codigo);
            ps.execute();
            return true;
        }
    }

    @Override
    public Pedir[] mostrar() throws SQLException {
        try (Connection con = DriverManager.getConnection(url, user, password)) {
            String sql = "SELECT * FROM PEDIR";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            ArrayList<Pedir> data = new ArrayList<>();
            while (rs.next()) {
                String codFactura = rs.getString(1);
                String codPedido = rs.getString(2);
                Pedir pedir = new Pedir(codPedido, codFactura);
                data.add(pedir);
            }

            return data.toArray(new Pedir[0]);
        }
    }
}
