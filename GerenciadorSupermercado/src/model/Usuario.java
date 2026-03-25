package model;

public class Usuario {
	private String nome;
	private String CPF;
	private String tipo;
	private String senha;
	public Usuario(String nome, String CPF, String tipo, String senha) {
		super();
		this.nome = nome;
		this.CPF = CPF;
		this.tipo = tipo;
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
	
	public String getTipo() {
		return tipo;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setCPF(String CPF) {
		CPF = CPF;
	}
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
	
}
