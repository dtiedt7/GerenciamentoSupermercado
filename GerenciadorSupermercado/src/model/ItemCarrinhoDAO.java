package model;

public class ItemCarrinhoDAO {
	// CREATE - Criar um novo item do carrinho
	public ItemCarrinho criarItem(Produto produto, int quantidade) {
		return new ItemCarrinho(produto, quantidade);
	}
}

