package model;

public class Usuario {
	private String nome;
	private String CPF;
	private boolean admin;
	private String senha;
	public Usuario(String nome, String CPF, boolean admin, String senha) {
		super();
		this.nome = nome;
		this.CPF = CPF;
		this.admin = admin;
		this.senha = senha;
	}
	
	public Usuario() {
	
	}
	
	
	public String getNome() {
		return nome;
	}
	
	public String getCPF() {
		return CPF;
	}
	
	public boolean getAdmin() {
		return admin;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setCPF(String CPF) {
		CPF = CPF;
	}
	
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
	
}
