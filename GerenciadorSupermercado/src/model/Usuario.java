package model;

public class Usuario {
	private int id;
	private String nome;
	private String CPF;
	private boolean admin;
	private String senha;
	
	public Usuario(int id, String nome, String CPF, boolean admin, String senha) {
		super();
		this.id = id;
		this.nome = nome;
		this.CPF = CPF;
		this.admin = admin;
		this.senha = senha;
	}
	
	public Usuario(String nome, String CPF, boolean admin, String senha) {
		this(0, nome, CPF, admin, senha);
	}
	
	public Usuario() {
	
	}
	
	public int getId() {
		return id;
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
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setCPF(String CPF) {
		this.CPF = CPF;
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
