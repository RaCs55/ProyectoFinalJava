package modelo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import modelo.Factura;

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
	
}
