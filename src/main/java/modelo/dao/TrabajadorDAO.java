package modelo.dao;

import java.sql.*;
import java.util.ArrayList;

import modelo.Pedido;
import modelo.Pedir;
import modelo.Trabajador;


public class TrabajadorDAO extends ModeloDAO<Trabajador, String> {

	@Override
	public void agregar(Trabajador trabajador) throws SQLException {

		try (Connection con = baseDatosController.getConnection()) {
			String sql = "INSERT INTO trabajador (dni, nombre, apellidos, anyos_experiencia) VALUES (?, ?, ?, ?)";
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, trabajador.getDni());
			ps.setString(2, trabajador.getNombre());
			ps.setString(3, trabajador.getApellidos());
			ps.setInt(4, trabajador.getAnyosExperiencia());
			ps.execute();

		} 
	}

	@Override
	public void eliminar(String codigo) throws SQLException {
		try (Connection con = baseDatosController.getConnection()) {
			String sql = "DELETE FROM TRABAJADOR WHERE dni = ?";
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, codigo);
			ps.execute();
		}
	}

	@Override
	public Trabajador[] mostrar() throws SQLException {
		try (Connection con = baseDatosController.getConnection()) {
			String sql = "SELECT * FROM TRABAJADOR";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			ArrayList<Trabajador> data = new ArrayList<>();
			while (rs.next()) {
				String dni = rs.getString(1);
				String nombre = rs.getString(2);
				String apellido = rs.getString(3);
				int anyos_experiencia = rs.getInt(4);
				Trabajador trabajador = new Trabajador(dni, nombre, apellido, anyos_experiencia);
				data.add(trabajador);
			}

			return data.toArray(new Trabajador[0]);
		}
	}

}
