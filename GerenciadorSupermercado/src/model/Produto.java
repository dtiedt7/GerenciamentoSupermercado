package model;

public class Produto {

	private int id;
	private String nome_produto;
	private float preco;
	private int qtde_estoque;
	private String descricao;
	
	public Produto(int id, String nome_produto, float preco, int qtde_estoque, String descricao) {
		super();
		this.id = id;
		this.nome_produto = nome_produto;
		this.preco = preco;
		this.qtde_estoque = qtde_estoque;
		this.descricao = descricao;
	}
	
	public Produto(String nome_produto, float preco, int qtde_estoque, String descricao) {
		this(0, nome_produto, preco, qtde_estoque, descricao);
	}
	
	public Produto() {

	}
	
	public int getId() {
		return id;
	}
	
	public String getNome_produto() {
		return nome_produto;
	}
	
	public float getPreco() {
		return preco;
	}
	
	public int getQtde_estoque() {
		return qtde_estoque;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setNome_produto(String nome_produto) {
		this.nome_produto = nome_produto;
	}
	
	public void setPreco(float preco) {
		this.preco = preco;
	}
	
	public void setQtde_estoque(int qtde_estoque) {
		this.qtde_estoque = qtde_estoque;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
	
	
}
