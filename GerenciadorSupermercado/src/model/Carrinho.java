package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Carrinho {
	private final List<ItemCarrinho> itens = new ArrayList<>();

	public List<ItemCarrinho> getItens() {
		return Collections.unmodifiableList(itens);
	}

	public void limpar() {
		itens.clear();
	}

	public void adicionar(Produto produto, int quantidade) {
		if (produto == null || quantidade <= 0) {
			return;
		}
		for (ItemCarrinho item : itens) {
			if (item.getProduto().getId() == produto.getId()) {
				item.setQuantidade(item.getQuantidade() + quantidade);
				return;
			}
		}
		itens.add(new ItemCarrinho(produto, quantidade));
	}

	public void remover(Produto produto, int quantidade) {
		if (produto == null || quantidade <= 0) {
			return;
		}
		for (int i = 0; i < itens.size(); i++) {
			ItemCarrinho item = itens.get(i);
			if (item.getProduto().getId() == produto.getId()) {
				int novo = item.getQuantidade() - quantidade;
				if (novo <= 0) {
					itens.remove(i);
				} else {
					item.setQuantidade(novo);
				}
				return;
			}
		}
	}

	public float getTotal() {
		float total = 0f;
		for (ItemCarrinho item : itens) {
			total += item.getSubtotal();
		}
		return total;
	}

	public boolean isVazio() {
		return itens.isEmpty();
	}
}

