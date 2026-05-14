package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import model.Produto;
import model.ProdutoDAO;
import model.Usuario;
import view.TelaCadastroProdutos;

public class ProdutosController implements ActionListener {
	private static Usuario usuarioLogado;
	private static ProdutoDAO produtoDAOCompartilhado;

	private final TelaCadastroProdutos tela;
	private final ProdutoDAO produtoDAO;
	private final Navegador navegador;

	public ProdutosController(TelaCadastroProdutos tela, ProdutoDAO produtoDAO, Navegador navegador) {
		this.tela = tela;
		this.produtoDAO = produtoDAO;
		produtoDAOCompartilhado = produtoDAO;
		this.navegador = navegador;
	}

	public static void setUsuarioLogado(Usuario usuario) {
		usuarioLogado = usuario;
	}

	public static void carregarTabela(TelaCadastroProdutos tela) {
		if (produtoDAOCompartilhado == null) {
			return;
		}
		List<Produto> produtos = produtoDAOCompartilhado.listarProdutos();
		DefaultTableModel model = (DefaultTableModel) tela.getTabelaCadastroProduto().getModel();
		model.setRowCount(0);
		for (Produto p : produtos) {
			model.addRow(new Object[] { p.getId(), p.getNome_produto(), p.getPreco(), p.getDescricao(), p.getQtde_estoque() });
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		if (src == tela.getBtDeslogar()) {
			usuarioLogado = null;
			JOptionPane.showMessageDialog(null, "Usuário deslogado com sucesso.");
			navegador.navegarPara(LoginController.TELA_LOGIN);
			return;
		}

		if (usuarioLogado == null || !usuarioLogado.getAdmin()) {
			JOptionPane.showMessageDialog(null, "Acesso negado.", "Erro", JOptionPane.ERROR_MESSAGE);
			navegador.navegarPara(LoginController.TELA_LOGIN);
			return;
		}

		if (src == tela.getBtAdicionar()) {
			adicionar();
		} else if (src == tela.getBtEditar()) {
			editar();
		} else if (src == tela.getBtRemover()) {
			remover();
		}
	}

	private Integer idSelecionado() {
		int row = tela.getTabelaCadastroProduto().getSelectedRow();
		if (row < 0) return null;
		Object val = tela.getTabelaCadastroProduto().getValueAt(row, 0);
		try {
			return Integer.parseInt(String.valueOf(val));
		} catch (Exception ex) {
			return null;
		}
	}

	private void adicionar() {
		try {
			String nome = tela.getTfProduto().getText();
			float preco = Float.parseFloat(tela.getTfPreco().getText().replace(",", "."));
			int estoque = Integer.parseInt(tela.getTfEstoque().getText());
			String desc = tela.getTfDescricao().getText();

			if (nome == null || nome.trim().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Informe o nome do produto.", "Erro", JOptionPane.ERROR_MESSAGE);
				return;
			}
			
			if (produtoDAO.produtoExiste(nome.trim())) {
			    JOptionPane.showMessageDialog(null,
			        "Já existe um produto com esse nome.");

			    return;
			}
			produtoDAO.adicionarProduto(new Produto(nome.trim(), preco, estoque, desc == null ? "" : desc.trim()));
			JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso.");
			carregarTabela(tela);
		} catch (NumberFormatException ex) {
			JOptionPane.showMessageDialog(null, "Preço/Estoque inválidos.", "Erro", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void editar() {
		Integer id = idSelecionado();
		if (id == null) {
			JOptionPane.showMessageDialog(null, "Selecione um produto na tabela.", "Erro", JOptionPane.ERROR_MESSAGE);
			return;
		}
		try {
			String nome = tela.getTfProduto().getText();
			float preco = Float.parseFloat(tela.getTfPreco().getText().replace(",", "."));
			int estoque = Integer.parseInt(tela.getTfEstoque().getText());
			String desc = tela.getTfDescricao().getText();

			produtoDAO.atualizarProduto(new Produto(id, nome.trim(), preco, estoque, desc == null ? "" : desc.trim()));
			JOptionPane.showMessageDialog(null, "Produto atualizado com sucesso.");
			carregarTabela(tela);
		} catch (NumberFormatException ex) {
			JOptionPane.showMessageDialog(null, "Preço/Estoque inválidos.", "Erro", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void remover() {
		Integer id = idSelecionado();
		if (id == null) {
			JOptionPane.showMessageDialog(null, "Selecione um produto na tabela.", "Erro", JOptionPane.ERROR_MESSAGE);
			return;
		}
		produtoDAO.excluirProduto(id);
		JOptionPane.showMessageDialog(null, "Produto removido com sucesso.");
		carregarTabela(tela);
	}
}

