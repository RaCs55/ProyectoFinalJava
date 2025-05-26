package modelo.dao;

import java.sql.*;
import java.util.ArrayList;

import modelo.Factura;
import modelo.Producto;
import util.BaseDatosController;

public class FacturaDAO extends ModeloDAO<Factura, String> {

	@Override
	public void agregar(Factura factura) throws SQLException {
		try (Connection con = baseDatosController.getConnection()) {
			String sql = "INSERT INTO FACTURA (codFactura, forma_de_pago, precio_total) VALUES (?, ?, ?)";
			PreparedStatement ps = con.prepareStatement(sql);

			String sqlUltimaFactura = "SELECT obtenerUltimaFactura()";
			PreparedStatement ps2 = con.prepareStatement(sqlUltimaFactura);
			ResultSet rs = ps2.executeQuery();
			String codFactura = null;
			if (rs.next()) {
				codFactura = rs.getString(1);
			}


			ps.setString(1, codFactura);
			ps.setString(2, factura.getFormaPago());
			ps.setDouble(3, factura.getPrecioTotal());
			ps.execute();
		}
	}

	@Override
	public void eliminar(String codigo) throws SQLException {
		try (Connection con = baseDatosController.getConnection()) {
			String sql = "DELETE FROM FACTURA WHERE codfactura = ?";
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, codigo);
			ps.execute();
		}
	}

	@Override
	public Factura[] mostrar() throws SQLException {
		try (Connection con = baseDatosController.getConnection()) {
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
