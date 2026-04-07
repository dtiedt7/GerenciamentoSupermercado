package model;

import java.util.List;

public class NotaFiscal {
	private final String nome;
	private final String cpf;
	private final List<ItemCarrinho> itens;
	private final float total;

	public NotaFiscal(String nome, String cpf, List<ItemCarrinho> itens, float total) {
		this.nome = nome;
		this.cpf = cpf;
		this.itens = itens;
		this.total = total;
	}

	public String getNome() {
		return nome;
	}

	public String getCpf() {
		return cpf;
	}

	public List<ItemCarrinho> getItens() {
		return itens;
	}

	public float getTotal() {
		return total;
	}
}

