package modelo.dao;

import modelo.Factura;
import modelo.Producto;
import modelo.Proveedor;

import java.sql.*;
import java.util.ArrayList;

public class ProveedorDAO extends ModeloDAO<Proveedor, String> {
    @Override
    public boolean agregar(Proveedor proveedor) throws SQLException {
        try (Connection con = DriverManager.getConnection(url, user, password)) {
            String sql = "INSERT INTO PROVEEDOR (cifproveedor, nombre, direccion) VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, proveedor.getCifProveedor());
            ps.setString(2, proveedor.getNombre());
            ps.setString(3, proveedor.getDireccion());
            ps.execute();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean eliminar(String codigo) throws SQLException {
        try (Connection con = DriverManager.getConnection(url, user, password)) {
            String sql = "DELETE FROM PROVEEDOR WHERE cifproveedor = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, codigo);
            ps.execute();
            return true;
        }
    }

    @Override
    public Proveedor[] mostrar() throws SQLException {
        try (Connection con = DriverManager.getConnection(url, user, password)) {
            String sql = "SELECT * FROM PROVEEDOR";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            ArrayList<Proveedor> data = new ArrayList<>();
            while (rs.next()) {
                String cifProveedor = rs.getString(1);
                String nombre = rs.getString(2);
                String dirccion = rs.getString(3);
                Proveedor proveedor = new Proveedor(cifProveedor, nombre, dirccion);
                data.add(proveedor);
            }

            return data.toArray(new Proveedor[0]);
        }
    }

    public void borrarContenido() throws SQLException {
        try (Connection con = DriverManager.getConnection(url, user, password)) {
            String sql = "DELETE FROM PROVEEDOR";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.execute();
        }
    }
}
