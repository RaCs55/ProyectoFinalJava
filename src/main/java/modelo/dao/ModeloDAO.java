package modelo.dao;

import java.sql.SQLException;

import controlador.ConfiguracionBD;

public abstract class ModeloDAO<T, V> {
	private ConfiguracionBD configuracionBD = new ConfiguracionBD();
	protected String url = configuracionBD.getUrl();
	protected String user = configuracionBD.getUser();
	protected String password = configuracionBD.getPassword();
	
	
	public ModeloDAO() {

	}
	
	public abstract boolean agregar(T objeto) throws SQLException;
	public abstract boolean eliminar(V codigo) throws SQLException;

	
	
}
