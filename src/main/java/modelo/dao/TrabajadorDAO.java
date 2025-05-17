package modelo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import modelo.Pedido;
import modelo.Trabajador;


public class TrabajadorDAO extends ModeloDAO<Trabajador, String> {

	@Override
	public boolean agregar(Trabajador trabajador) throws SQLException {

		try (Connection con = DriverManager.getConnection(url, user, password)) {
			String sql = "INSERT INTO TRABAJADOR (dni, nombre, apellidos, anyos_experencia) VALUES (?, ?, ?, ?)";
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, trabajador.getDni());
			ps.setString(2, trabajador.getNombre());
			ps.setString(3, trabajador.getApellidos());
			ps.setInt(4, trabajador.getAnyosExperiencia());
			ps.execute();
			return true;

		} 
	}

	@Override
	public boolean eliminar(String codigo) throws SQLException {
		try (Connection con = DriverManager.getConnection(url, user, password)) {
			String sql = "DELETE FROM TRABAJADOR WHERE dni = ?";
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, codigo);
			ps.execute();
			return true;
		}
	}

}
