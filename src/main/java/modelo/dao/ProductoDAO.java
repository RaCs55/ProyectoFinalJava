package modelo.dao;

import java.sql.*;
import java.util.ArrayList;


import modelo.Producto;
import modelo.Trabajador;


public class ProductoDAO extends ModeloDAO<Producto, String>{
	

	@Override
	public boolean agregar(Producto producto) throws SQLException{
	    try (Connection con = DriverManager.getConnection(url, user, password)) {
	        String sql = "INSERT INTO PRODUCTO (codproducto, nombre, tipo, precio) VALUES (?, ?, ?, ?)";
	        PreparedStatement ps = con.prepareStatement(sql);

	        ps.setString(1, producto.getCodProducto());
			ps.setString(2, producto.getNombre());
			ps.setString(3, producto.getTipo());
	        ps.setDouble(4, producto.getPrecio());
	        ps.execute();
	        return true;
	    }
	}

	@Override
	public boolean eliminar(String codigo) throws SQLException {
		try (Connection con = DriverManager.getConnection(url, user, password)) {
			String sql = "DELETE FROM PRODUCTO WHERE codproducto = ?";
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, codigo);
			ps.execute();
			return true;
		}
	}

	@Override
	public Producto[] mostrar() throws SQLException {
		try (Connection con = DriverManager.getConnection(url, user, password)) {
			String sql = "SELECT * FROM PRODUCTO";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			ArrayList<Producto> data = new ArrayList<>();
			while (rs.next()) {
				String codProducto = rs.getString(1);
				String nombre = rs.getString(2);
				String tipo = rs.getString(3);
				double precio = rs.getDouble(4);
				Producto producto = new Producto(codProducto, nombre, tipo, precio);
				data.add(producto);
			}

			return data.toArray(new Producto[0]);
		}
	}


}
