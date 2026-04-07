package model;

import java.util.ArrayList;
import java.util.List;

public class Supermercado {
	private final UsuarioDAO usuarioDAO;
	private final ProdutoDAO produtoDAO;

	public Supermercado() {
		this(new UsuarioDAO(), new ProdutoDAO());
	}

	public Supermercado(UsuarioDAO usuarioDAO, ProdutoDAO produtoDAO) {
		this.usuarioDAO = usuarioDAO;
		this.produtoDAO = produtoDAO;
	}

	public Usuario login(String nome, String cpf) {
		if (nome == null || cpf == null) {
			return null;
		}
		nome = nome.trim();
		cpf = cpf.trim();
		if (nome.isEmpty() || cpf.isEmpty()) {
			return null;
		}
		return usuarioDAO.buscarPorNomeECpf(nome, cpf);
	}

	public void cadastrarUsuario(Usuario usuario) {
		usuarioDAO.adicionarUsuario(usuario);
	}

	public List<Produto> listarProdutos() {
		return produtoDAO.listarProdutos();
	}

	public void cadastrarProduto(Produto produto) {
		produtoDAO.adicionarProduto(produto);
	}

	public void atualizarProduto(Produto produto) {
		produtoDAO.atualizarProduto(produto);
	}

	public void removerProduto(int id) {
		produtoDAO.excluirProduto(id);
	}

	public NotaFiscal comprar(Usuario usuario, Carrinho carrinho) {
		if (usuario == null || carrinho == null || carrinho.isVazio()) {
			return null;
		}
		if (usuario.getAdmin()) {
			return null;
		}

		List<ItemCarrinho> itensParaNota = new ArrayList<>();
		for (ItemCarrinho item : carrinho.getItens()) {
			Produto produtoAtual = produtoDAO.buscarPorId(item.getProduto().getId());
			if (produtoAtual == null) {
				return null;
			}
			if (item.getQuantidade() > produtoAtual.getQtde_estoque()) {
				return null;
			}
			itensParaNota.add(new ItemCarrinho(produtoAtual, item.getQuantidade()));
		}

		for (ItemCarrinho item : itensParaNota) {
			int novoEstoque = item.getProduto().getQtde_estoque() - item.getQuantidade();
			produtoDAO.atualizarEstoque(item.getProduto().getId(), novoEstoque);
		}

		float total = 0f;
		for (ItemCarrinho item : itensParaNota) {
			total += item.getSubtotal();
		}

		return new NotaFiscal(usuario.getNome(), usuario.getCPF(), itensParaNota, total);
	}
}

