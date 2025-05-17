package modelo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import modelo.Mesa;
import modelo.Pedido;

public class PedidoDAO extends ModeloDAO<Pedido, String> {

	@Override
	public boolean agregar(Pedido pedido) throws SQLException {
		try (Connection con = DriverManager.getConnection(url, user, password)) {
			String sql = "INSERT INTO PEDIDO (codigo, comida, bebida) VALUES (?, ?, ?)";
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, pedido.getCodPedido());
			ps.setString(2, pedido.getComida());
			ps.setString(3, pedido.getBebida());
			ps.execute();
			return true;

		}

	}

	@Override
	public boolean eliminar(String codigo) throws SQLException {
		try (Connection con = DriverManager.getConnection(url, user, password)) {
			String sql = "DELETE FROM PEDIDO WHERE codigo = ?";
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, codigo);
			ps.execute();
			return true;
		}
	}

}
