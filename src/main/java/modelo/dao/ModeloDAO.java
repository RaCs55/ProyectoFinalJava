package modelo.dao;

import java.sql.SQLException;

import util.BaseDatosController;

public abstract class ModeloDAO<T, V> {
	protected BaseDatosController baseDatosController = new BaseDatosController();

	public abstract void agregar(T objeto) throws SQLException;
	public abstract void eliminar(V codigo) throws SQLException;
	public abstract T[] mostrar() throws SQLException;
}
