package modelo.dao;

import java.sql.*;
import java.util.ArrayList;

import modelo.Factura;
import modelo.Producto;

public class FacturaDAO extends ModeloDAO<Factura, String> {

	@Override
	public boolean agregar(Factura factura) throws SQLException {
		try (Connection con = DriverManager.getConnection(url, user, password)) {
			String sql = "INSERT INTO FACTURA (codfactura, forma_de_pago, precio_total) VALUES (?, ?, ?)";
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, factura.getCodFactura());
			ps.setString(2, factura.getFormaPago());
			ps.setDouble(3, factura.getPrecioTotal());
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
			String sql = "DELETE FROM FACTURA WHERE codfactura = ?";
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, codigo);
			ps.execute();
			return true;
		}
	}

	@Override
	public Factura[] mostrar() throws SQLException {
		try (Connection con = DriverManager.getConnection(url, user, password)) {
			String sql = "SELECT * FROM FACTURA";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			ArrayList<Factura> data = new ArrayList<>();
			while (rs.next()) {
				String codFactura = rs.getString(1);
				String forma_de_pago = rs.getString(2);
				double precio_total = rs.getDouble(3);
				Factura factura = new Factura(codFactura, forma_de_pago, precio_total);
				data.add(factura);
			}

			return data.toArray(new Factura[0]);
		}
	}

}
