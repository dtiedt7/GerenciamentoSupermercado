package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import model.Carrinho;
import model.ItemCarrinho;
import model.NotaFiscal;
import model.Produto;
import model.Supermercado;
import model.Usuario;
import view.TelaCompra;
import view.TelaNotaFiscal;

public class CompraController implements ActionListener {
	private static Usuario usuarioLogado;
	private static final Carrinho carrinho = new Carrinho();

	private final TelaCompra tela;
	private final TelaNotaFiscal telaNotaFiscal;
	private final Supermercado supermercado;
	private final Navegador navegador;

	public CompraController(TelaCompra tela, TelaNotaFiscal telaNotaFiscal, Supermercado supermercado, Navegador navegador) {
		this.tela = tela;
		this.telaNotaFiscal = telaNotaFiscal;
		this.supermercado = supermercado;
		this.navegador = navegador;
	}

	public static void setUsuarioLogado(Usuario usuario) {
		usuarioLogado = usuario;
		carrinho.limpar();
	}

	public static void recarregarProdutos(TelaCompra tela, Supermercado supermercado) {
		List<Produto> produtos = supermercado.listarProdutos();
		DefaultTableModel model = (DefaultTableModel) tela.getTabelaProdutos().getModel();
		model.setRowCount(0);
		for (Produto p : produtos) {
			model.addRow(new Object[] { p.getId(), p.getNome_produto(), p.getPreco(), p.getQtde_estoque() });
		}
	}

	public static void atualizarCarrinho(TelaCompra tela) {
		DefaultTableModel model = (DefaultTableModel) tela.getTabelaCarrinho().getModel();
		model.setRowCount(0);
		for (ItemCarrinho item : carrinho.getItens()) {
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
		for (Produto p : supermercado.listarProdutos()) {
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
		Produto prod = new Produto();
		prod.setId(id);
		carrinho.remover(prod, 1);
		atualizarCarrinho(tela);
	}

	private void finalizarCompra() {
		if (carrinho.isVazio()) {
			JOptionPane.showMessageDialog(null, "Carrinho vazio.", "Erro", JOptionPane.ERROR_MESSAGE);
			return;
		}
		NotaFiscal nf = supermercado.comprar(usuarioLogado, carrinho);
		if (nf == null) {
			JOptionPane.showMessageDialog(null, "Não foi possível finalizar a compra (estoque/BD).", "Erro",
					JOptionPane.ERROR_MESSAGE);
			return;
		}

		StringBuilder sb = new StringBuilder("<html>Produtos:<br/>");
		for (ItemCarrinho item : nf.getItens()) {
			sb.append(item.getProduto().getNome_produto()).append(" x ").append(item.getQuantidade()).append(" = R$ ")
					.append(String.format("%.2f", item.getSubtotal())).append("<br/>");
		}
		sb.append("</html>");

		telaNotaFiscal.setNome(nf.getNome());
		telaNotaFiscal.setCpf(nf.getCpf());
		telaNotaFiscal.setProdutosTexto(sb.toString());
		telaNotaFiscal.setTotal(nf.getTotal());

		JOptionPane.showMessageDialog(null, "Nota fiscal emitida!\nNome: " + nf.getNome() + "\nCPF: " + nf.getCpf()
				+ "\nTotal: R$ " + String.format("%.2f", nf.getTotal()));

		carrinho.limpar();
		recarregarProdutos(tela, supermercado);
		atualizarCarrinho(tela);
		navegador.navegarPara(LoginController.TELA_NOTA_FISCAL);
	}
}

