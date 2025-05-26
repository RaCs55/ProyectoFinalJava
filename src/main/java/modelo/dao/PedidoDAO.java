package modelo.dao;

import java.sql.*;
import java.util.ArrayList;

import modelo.Pedido;

public class PedidoDAO extends ModeloDAO<Pedido, String> {

	@Override
	public void agregar(Pedido pedido) throws SQLException {
		try (Connection con = baseDatosController.getConnection()) {
			String sql = "INSERT INTO PEDIDO (codpedido, comida, bebida, forma_de_pago) VALUES (?, ?, ?, ?)";
			PreparedStatement ps = con.prepareStatement(sql);

			String sqlUltimaPedido = "SELECT obtenerUltimoPedido()";
			PreparedStatement ps2 = con.prepareStatement(sqlUltimaPedido);
			ResultSet rs = ps2.executeQuery();
			String codPedido = null;
			if (rs.next()) {
				codPedido = rs.getString(1);
			}



			ps.setString(1, codPedido);
			ps.setString(2, pedido.getComida());
			ps.setString(3, pedido.getBebida());
			ps.setString(4, pedido.getFormaDePago());
			ps.execute();
		}

	}

	@Override
	public void eliminar(String codigo) throws SQLException {
		try (Connection con = baseDatosController.getConnection()) {
			String sql = "DELETE FROM PEDIDO WHERE codPedido = ?";
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, codigo);
			ps.execute();
		}
	}

	@Override
	public Pedido[] mostrar() throws SQLException {
		try (Connection con = baseDatosController.getConnection()) {
			String sql = "SELECT * FROM PEDIDO";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			ArrayList<Pedido> data = new ArrayList<>();
			while (rs.next()) {
				String codPedido = rs.getString(1);
				String comida = rs.getString(2);
				String bebida = rs.getString(3);
				String formaDePago = rs.getString(4);
				Pedido pedido = new Pedido(codPedido, comida, bebida, formaDePago);
				data.add(pedido);
			}

			return data.toArray(new Pedido[0]);
		}
	}

}
