package controlador;

public class ConfiguracionBD {
	private  String url = "jdbc:postgresql://localhost:5432/Proyecto";
	private String user = "postgres";
	private String password = "postgres";
	
	
	public ConfiguracionBD() {

	}


	public String getUrl() {
		return url;
	}


	public void setUrl(String url) {
		this.url = url;
	}


	public String getUser() {
		return user;
	}


	public void setUser(String user) {
		this.user = user;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
