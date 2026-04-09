package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import model.Carrinho;
import model.Produto;
import model.CarrinhoDAO;
import model.ProdutoDAO;
import model.Usuario;
import view.TelaCompra;

public class CompraController implements ActionListener {
	private static Usuario usuarioLogado;
	private static Carrinho carrinho = new Carrinho();
	private static ProdutoDAO produtoDAOCompartilhado;
	private static CarrinhoDAO carrinhoDAOCompartilhado;

	private final TelaCompra tela;
	private final ProdutoDAO produtoDAO;
	private final CarrinhoDAO carrinhoDAO;
	private final Navegador navegador;

	public CompraController(TelaCompra tela, ProdutoDAO produtoDAO, CarrinhoDAO carrinhoDAO, Navegador navegador) {
		this.tela = tela;
		this.produtoDAO = produtoDAO;
		this.carrinhoDAO = carrinhoDAO;
		produtoDAOCompartilhado = produtoDAO;
		carrinhoDAOCompartilhado = carrinhoDAO;
		this.navegador = navegador;
	}

	public static void setUsuarioLogado(Usuario usuario) {
		usuarioLogado = usuario;
		carrinho.limpar();
	}

	public static void recarregarProdutos(TelaCompra tela) {
		if (produtoDAOCompartilhado == null) {
			return;
		}
		List<Produto> produtos = produtoDAOCompartilhado.listarProdutos();
		DefaultTableModel model = (DefaultTableModel) tela.getTabelaProdutos().getModel();
		model.setRowCount(0);
		for (Produto p : produtos) {
			model.addRow(new Object[] { p.getId(), p.getNome_produto(), p.getPreco(), p.getQtde_estoque() });
		}
	}

	public static void atualizarCarrinho(TelaCompra tela) {
		DefaultTableModel model = (DefaultTableModel) tela.getTabelaCarrinho().getModel();
		model.setRowCount(0);
		for (Carrinho.Item item : carrinho.getItens()) {
			model.addRow(new Object[] { item.getProduto().getId(), item.getProduto().getNome_produto(), item.getQuantidade(),
					item.getSubtotal() });
		}
		tela.getLbTotalCompra().setText(String.format("Total: R$ %.2f", carrinho.getTotal()));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();

		if (src == tela.getBtDeslogar()) {
			usuarioLogado = null;
			carrinho.limpar();
			JOptionPane.showMessageDialog(null, "Usuário deslogado com sucesso.");
			navegador.navegarPara(LoginController.TELA_LOGIN);
			return;
		}

		if (usuarioLogado == null || usuarioLogado.getAdmin()) {
			JOptionPane.showMessageDialog(null, "Acesso negado.", "Erro", JOptionPane.ERROR_MESSAGE);
			navegador.navegarPara(LoginController.TELA_LOGIN);
			return;
		}

		if (src == tela.getBtAdicionar()) {
			adicionarAoCarrinho();
		} else if (src == tela.getBtRemover()) {
			removerDoCarrinho();
		} else if (src == tela.getBtFinalizarCompra()) {
			finalizarCompra();
		}
	}

	private Integer idSelecionadoProdutos() {
		int row = tela.getTabelaProdutos().getSelectedRow();
		if (row < 0) return null;
		try {
			return Integer.parseInt(String.valueOf(tela.getTabelaProdutos().getValueAt(row, 0)));
		} catch (Exception ex) {
			return null;
		}
	}

	private Integer idSelecionadoCarrinho() {
		int row = tela.getTabelaCarrinho().getSelectedRow();
		if (row < 0) return null;
		try {
			return Integer.parseInt(String.valueOf(tela.getTabelaCarrinho().getValueAt(row, 0)));
		} catch (Exception ex) {
			return null;
		}
	}

	private void adicionarAoCarrinho() {
		Integer id = idSelecionadoProdutos();
		if (id == null) {
			JOptionPane.showMessageDialog(null, "Selecione um produto para adicionar.", "Erro", JOptionPane.ERROR_MESSAGE);
			return;
		}
		Produto produto = null;
		for (Produto p : produtoDAO.listarProdutos()) {
			if (p.getId() == id) {
				produto = p;
				break;
			}
		}
		if (produto == null) {
			JOptionPane.showMessageDialog(null, "Produto não encontrado.", "Erro", JOptionPane.ERROR_MESSAGE);
			return;
		}
		carrinho.adicionar(produto, 1);
		atualizarCarrinho(tela);
	}

	private void removerDoCarrinho() {
		Integer id = idSelecionadoCarrinho();
		if (id == null) {
			JOptionPane.showMessageDialog(null, "Selecione um item do carrinho para remover.", "Erro", JOptionPane.ERROR_MESSAGE);
			return;
		}
		carrinho.removerPorId(id, 1);
		atualizarCarrinho(tela);
	}

	private void finalizarCompra() {
		if (carrinho.isVazio()) {
			JOptionPane.showMessageDialog(null, "Carrinho vazio.", "Erro", JOptionPane.ERROR_MESSAGE);
			return;
		}
		float total = 0f;
		StringBuilder sb = new StringBuilder("NOTA FISCAL\n");
		sb.append("Cliente: ").append(usuarioLogado.getNome()).append("\n");
		sb.append("CPF: ").append(usuarioLogado.getCPF()).append("\n");
		sb.append("--------------------\n");

		for (Carrinho.Item item : carrinho.getItens()) {
			Produto produtoNoBanco = produtoDAO.buscarPorId(item.getProduto().getId());
			if (produtoNoBanco == null || produtoNoBanco.getQtde_estoque() < item.getQuantidade()) {
				JOptionPane.showMessageDialog(null, "Estoque insuficiente para " + item.getProduto().getNome_produto(), "Erro",
						JOptionPane.ERROR_MESSAGE);
				return;
			}
		}

		for (Carrinho.Item item : carrinho.getItens()) {
			Produto produtoNoBanco = produtoDAO.buscarPorId(item.getProduto().getId());
			int novoEstoque = produtoNoBanco.getQtde_estoque() - item.getQuantidade();
			produtoDAO.atualizarEstoque(produtoNoBanco.getId(), novoEstoque);
			carrinhoDAO.registrarItemCompra(usuarioLogado.getId(), produtoNoBanco.getId(), item.getQuantidade(),
					produtoNoBanco.getPreco());

			total += item.getSubtotal();
			sb.append(item.getProduto().getNome_produto()).append(" x ").append(item.getQuantidade()).append(" = R$ ")
					.append(String.format("%.2f", item.getSubtotal())).append("\n");
		}

		sb.append("--------------------\n");
		sb.append("TOTAL: R$ ").append(String.format("%.2f", total));
		JOptionPane.showMessageDialog(null, sb.toString());

		carrinhoDAOCompartilhado.limparCarrinho(carrinho);
		recarregarProdutos(tela);
		atualizarCarrinho(tela);
	}
}

