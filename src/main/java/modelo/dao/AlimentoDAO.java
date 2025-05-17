package modelo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


import modelo.Alimento;


public class AlimentoDAO extends ModeloDAO<Alimento, Integer>{
	

	@Override
	public boolean agregar(Alimento alimento) throws SQLException{
	    try (Connection con = DriverManager.getConnection(url, user, password)) {
	        String sql = "INSERT INTO ALIMENTO (codigo, tipo, nombre) VALUES (?, ?, ?)";
	        PreparedStatement ps = con.prepareStatement(sql);

	        ps.setInt(1, alimento.getCodAlimento());
	        ps.setString(2, alimento.getTipo());
	        ps.setString(3, alimento.getNombre());
	        ps.execute();
	        return true;
	    }
	}

	@Override
	public boolean eliminar(Integer codigo) throws SQLException {
		try (Connection con = DriverManager.getConnection(url, user, password)) {
			String sql = "DELETE FROM ALIMENTO WHERE codigo = ?";
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, codigo);
			ps.execute();
			return true;
		}
	}


}
