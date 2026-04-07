package model;

public class CarrinhoDAO {
	// CREATE - Criar um novo carrinho
	public Carrinho criarCarrinho() {
		return new Carrinho();
	}

	// DELETE - Limpar carrinho (remove todos os itens)
	public void limparCarrinho(Carrinho carrinho) {
		if (carrinho != null) {
			carrinho.limpar();
		}
	}
}

