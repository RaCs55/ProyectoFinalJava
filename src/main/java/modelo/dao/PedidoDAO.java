package modelo.dao;

import java.sql.*;
import java.util.ArrayList;

import modelo.Mesa;
import modelo.Pedido;
import modelo.Pedir;

public class PedidoDAO extends ModeloDAO<Pedido, String> {

	@Override
	public boolean agregar(Pedido pedido) throws SQLException {
		try (Connection con = DriverManager.getConnection(url, user, password)) {
			String sql = "INSERT INTO PEDIDO (codpedido, comida, bebida) VALUES (?, ?, ?)";
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
			String sql = "DELETE FROM PEDIDO WHERE codPedido = ?";
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, codigo);
			ps.execute();
			return true;
		}
	}

	@Override
	public Pedido[] mostrar() throws SQLException {
		try (Connection con = DriverManager.getConnection(url, user, password)) {
			String sql = "SELECT * FROM PEDIDO";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			ArrayList<Pedido> data = new ArrayList<>();
			while (rs.next()) {
				String codPedido = rs.getString(1);
				String comida = rs.getString(2);
				String bebida = rs.getString(3);
				Pedido pedido = new Pedido(codPedido, comida, bebida);
				data.add(pedido);
			}

			return data.toArray(new Pedido[0]);
		}
	}

}
