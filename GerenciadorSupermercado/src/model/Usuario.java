package model;

public class Usuario {
	private String user;
	private String CPF;
	private String tipo;
	public Usuario(String user, String CPF, String tipo) {
		super();
		this.user = user;
		CPF = CPF;
		this.tipo = tipo;
	}
	public String getUser() {
		return user;
	}
	public String getCPF() {
		return CPF;
	}
	public String getTipo() {
		return tipo;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public void setCPF(String CPF) {
		CPF = CPF;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	
}
