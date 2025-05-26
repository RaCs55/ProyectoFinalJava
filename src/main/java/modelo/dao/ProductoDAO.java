package modelo.dao;

import java.sql.*;
import java.util.ArrayList;


import modelo.Producto;
import modelo.Trabajador;


public class ProductoDAO extends ModeloDAO<Producto, String>{
	

	@Override
	public void agregar(Producto producto) throws SQLException{
	    try (Connection con = baseDatosController.getConnection()) {
	        String sql = "INSERT INTO PRODUCTO (codproducto, nombre, tipo, precio) VALUES (?, ?, ?, ?)";
	        PreparedStatement ps = con.prepareStatement(sql);

			String sqlUltimoProducto = "SELECT obtenerUltimoProducto()";
			PreparedStatement ps2 = con.prepareStatement(sqlUltimoProducto);
			ResultSet rs = ps2.executeQuery();
			String codProducto = null;
			if (rs.next()) {
				codProducto = rs.getString(1);
			}

			ps.setString(1, codProducto);
			ps.setString(2, producto.getNombre());
			ps.setString(3, producto.getTipo());
	        ps.setDouble(4, producto.getPrecio());
	        ps.execute();
	    }
	}

	@Override
	public void eliminar(String codigo) throws SQLException {
		try (Connection con = baseDatosController.getConnection()) {
			String sql = "DELETE FROM PRODUCTO WHERE codproducto = ?";
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, codigo);
			ps.execute();
		}
	}

	@Override
	public Producto[] mostrar() throws SQLException {
		try (Connection con = baseDatosController.getConnection()) {
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

	public String[] obtenerNombreProducto() throws SQLException {
		try (Connection con = baseDatosController.getConnection()) {
			String sql = "SELECT nombre FROM PRODUCTO WHERE tipo = 'Menú' OR tipo = 'Entrante' OR tipo = 'Postre'";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			ArrayList<String> productos = new ArrayList<>();
			while (rs.next()) {
				String nombre = rs.getString("nombre");
                productos.add(nombre);
			}
			return productos.toArray(new String[0]);
		}
	}

	public String[] obtenerBebidasProducto() throws SQLException {
		try (Connection con = baseDatosController.getConnection()) {
			String sql = "SELECT nombre FROM PRODUCTO WHERE tipo = 'Bebida'";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			ArrayList<String> bebidas = new ArrayList<>();
			while (rs.next()) {
				String nombre = rs.getString("nombre");
				bebidas.add(nombre);
			}
			return bebidas.toArray(new String[0]);
		}
	}


}
