package model;

public class Produto {

	private String nome_produto;
	private float preco;
	private int qtde_estoque;
	private String descricao;
	
	public Produto(String nome_produto, float preco, int qtde_estoque, String descricao) {
		super();
		this.nome_produto = nome_produto;
		this.preco = preco;
		this.qtde_estoque = qtde_estoque;
		this.descricao = descricao;
	}
	
	public Produto() {

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
