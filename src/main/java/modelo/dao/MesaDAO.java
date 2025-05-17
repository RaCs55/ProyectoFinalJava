package modelo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import modelo.Factura;
import modelo.Mesa;

public class MesaDAO extends ModeloDAO<Mesa, Integer> {

	@Override
	public boolean agregar(Mesa mesa) throws SQLException {
		try (Connection con = DriverManager.getConnection(url, user, password)) {
			String sql = "INSERT INTO MESA (numero, capacidad) VALUES (?, ?)";
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, mesa.getNumeroMesa());
			ps.setInt(2, mesa.getCapacidad());
			ps.execute();
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean eliminar(Integer codigo) throws SQLException {
		try (Connection con = DriverManager.getConnection(url, user, password)) {
			String sql = "DELETE FROM MESA WHERE numero = ?";
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, codigo);
			ps.execute();
			return true;
		}
	}

}
