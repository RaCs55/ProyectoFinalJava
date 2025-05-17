package modelo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import modelo.Alimento;
import modelo.Cliente;

public class ClienteDAO extends ModeloDAO<Cliente, Integer> {

	@Override
	public boolean agregar(Cliente cliente) throws SQLException {
		try (Connection con = DriverManager.getConnection(url, user, password)) {
			String sql = "INSERT INTO CLIENTE (numcliente, nombre, numero_mesa) VALUES (?, ?, ?)";
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, cliente.getNumCliente());
			ps.setString(2, cliente.getNombre());
			ps.setInt(3, cliente.getMesa());
			ps.execute();
			return true;

		}
	}

	@Override
	public boolean eliminar(Integer codigo) throws SQLException {
		try (Connection con = DriverManager.getConnection(url, user, password)) {
			String sql = "DELETE FROM CLIENTE WHERE numcliente = ?";
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, codigo);
			ps.execute();
			return true;
		}
	}
}
