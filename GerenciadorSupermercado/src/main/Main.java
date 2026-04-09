package main;

import java.awt.Font;

import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;

import controller.CadastroUsuarioController;
import controller.LoginController;
import controller.Navegador;
import controller.ProdutosController;
import controller.CompraController;
import model.CarrinhoDAO;
import model.ProdutoDAO;
import model.UsuarioDAO;
import view.Janela;
import view.TelaCadastroProdutos;
import view.TelaCadastroUsuarios;
import view.TelaCompra;
import view.TelaLogin;

public class Main {
	public static void main(String[] args) {
		UIManager.put("OptionPane.messageFont",
				new FontUIResource(new Font("Arial", Font.PLAIN, 18)));

		Janela janela = new Janela();
		Navegador navegador = new Navegador(janela);
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		ProdutoDAO produtoDAO = new ProdutoDAO();
		CarrinhoDAO carrinhoDAO = new CarrinhoDAO();

		TelaLogin telaLogin = new TelaLogin();
		TelaCadastroUsuarios telaCadastroUsuarios = new TelaCadastroUsuarios();
		TelaCadastroProdutos telaCadastroProdutos = new TelaCadastroProdutos();
		TelaCompra telaCompra = new TelaCompra();

		LoginController loginController = new LoginController(telaLogin, usuarioDAO, navegador, telaCadastroProdutos, telaCompra);
		telaLogin.getBtLogin().addActionListener(loginController);
		telaLogin.getBtCadastrarUsuario().addActionListener(loginController);

		CadastroUsuarioController cadastroUsuarioController = new CadastroUsuarioController(telaCadastroUsuarios, usuarioDAO, navegador);
		telaCadastroUsuarios.getBtCadastrar().addActionListener(cadastroUsuarioController);
		telaCadastroUsuarios.getBtVoltar().addActionListener(cadastroUsuarioController);

		ProdutosController produtosController = new ProdutosController(telaCadastroProdutos, produtoDAO, navegador);
		telaCadastroProdutos.getBtAdicionar().addActionListener(produtosController);
		telaCadastroProdutos.getBtEditar().addActionListener(produtosController);
		telaCadastroProdutos.getBtRemover().addActionListener(produtosController);
		telaCadastroProdutos.getBtDeslogar().addActionListener(produtosController);

		CompraController compraController = new CompraController(telaCompra, produtoDAO, carrinhoDAO, navegador);
		telaCompra.getBtAdicionar().addActionListener(compraController);
		telaCompra.getBtRemover().addActionListener(compraController);
		telaCompra.getBtFinalizarCompra().addActionListener(compraController);
		telaCompra.getBtDeslogar().addActionListener(compraController);

		navegador.adicionarPainel(LoginController.TELA_LOGIN, telaLogin);
		navegador.adicionarPainel(LoginController.TELA_CADASTRO_USUARIO, telaCadastroUsuarios);
		navegador.adicionarPainel(LoginController.TELA_CADASTRO_PRODUTOS, telaCadastroProdutos);
		navegador.adicionarPainel(LoginController.TELA_COMPRA, telaCompra);

		janela.setLocationRelativeTo(null);
		janela.setVisible(true);
		navegador.navegarPara(LoginController.TELA_LOGIN);
	}
}

