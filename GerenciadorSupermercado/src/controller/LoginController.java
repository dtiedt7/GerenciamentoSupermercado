package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.Usuario;
import model.UsuarioDAO;
import view.TelaCadastroProdutos;
import view.TelaCompra;
import view.TelaLogin;

public class LoginController implements ActionListener {
	public static final String TELA_LOGIN = "LOGIN";
	public static final String TELA_CADASTRO_USUARIO = "CADASTRO_USUARIO";
	public static final String TELA_CADASTRO_PRODUTOS = "CADASTRO_PRODUTOS";
	public static final String TELA_COMPRA = "COMPRA";

	private final TelaLogin tela;
	private final UsuarioDAO usuarioDAO;
	private final Navegador navegador;
	private final TelaCadastroProdutos telaProdutos;
	private final TelaCompra telaCompra;

	public LoginController(TelaLogin tela, UsuarioDAO usuarioDAO, Navegador navegador, TelaCadastroProdutos telaProdutos,
			TelaCompra telaCompra) {
		this.tela = tela;
		this.usuarioDAO = usuarioDAO;
		this.navegador = navegador;
		this.telaProdutos = telaProdutos;
		this.telaCompra = telaCompra;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		if (src == tela.getBtCadastrarUsuario()) {
			navegador.navegarPara(TELA_CADASTRO_USUARIO);
			return;
		}
		if (src == tela.getBtLogin()) {
			String nome = tela.getTfUsuario().getText();
			String cpf = tela.getTfCPF().getText();

			Usuario usuario = usuarioDAO.buscarPorNomeECpf(nome, cpf);
			if (usuario == null) {
				JOptionPane.showMessageDialog(null, "Usuário não encontrado. Verifique nome e CPF.", "Erro",
						JOptionPane.ERROR_MESSAGE);
				return;
			}

			if (usuario.getAdmin()) {
				ProdutosController.setUsuarioLogado(usuario);
				ProdutosController.carregarTabela(telaProdutos);
				navegador.navegarPara(TELA_CADASTRO_PRODUTOS);
			} else {
				CompraController.setUsuarioLogado(usuario);
				CompraController.recarregarProdutos(telaCompra);
				CompraController.atualizarCarrinho(telaCompra);
				navegador.navegarPara(TELA_COMPRA);
			}
		}
	}
}

