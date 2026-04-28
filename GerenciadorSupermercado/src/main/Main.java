package main;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;

import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;

import controller.CadastroUsuarioController;
import controller.LoginController;
import controller.Navegador;
import controller.ProdutosController;
import controller.CompraController;
import model.Supermercado;
import view.Janela;
import view.TelaCadastroProdutos;
import view.TelaCadastroUsuarios;
import view.TelaCompra;
import view.TelaLogin;
import view.TelaNotaFiscal;

public class Main {
	public static void main(String[] args) throws FontFormatException, IOException {
		UIManager.put("OptionPane.messageFont",
				new FontUIResource(new Font("Arial", Font.PLAIN, 18)));

		Janela janela = new Janela();
		Navegador navegador = new Navegador(janela);
		Supermercado supermercado = new Supermercado();

		TelaLogin telaLogin = new TelaLogin();
		TelaCadastroUsuarios telaCadastroUsuarios = new TelaCadastroUsuarios();
		TelaCadastroProdutos telaCadastroProdutos = new TelaCadastroProdutos();
		TelaCompra telaCompra = new TelaCompra();
		TelaNotaFiscal telaNotaFiscal = new TelaNotaFiscal();

		LoginController loginController = new LoginController(telaLogin, supermercado, navegador, telaCadastroProdutos, telaCompra);
		telaLogin.getBtLogin().addActionListener(loginController);
		telaLogin.getBtCadastrarUsuario().addActionListener(loginController);

		CadastroUsuarioController cadastroUsuarioController = new CadastroUsuarioController(telaCadastroUsuarios, supermercado, navegador);
		telaCadastroUsuarios.getBtCadastrar().addActionListener(cadastroUsuarioController);
		telaCadastroUsuarios.getBtVoltar().addActionListener(cadastroUsuarioController);

		ProdutosController produtosController = new ProdutosController(telaCadastroProdutos, supermercado, navegador);
		telaCadastroProdutos.getBtAdicionar().addActionListener(produtosController);
		telaCadastroProdutos.getBtEditar().addActionListener(produtosController);
		telaCadastroProdutos.getBtRemover().addActionListener(produtosController);
		telaCadastroProdutos.getBtDeslogar().addActionListener(produtosController);

		CompraController compraController = new CompraController(telaCompra, telaNotaFiscal, supermercado, navegador);
		telaCompra.getBtAdicionar().addActionListener(compraController);
		telaCompra.getBtRemover().addActionListener(compraController);
		telaCompra.getBtFinalizarCompra().addActionListener(compraController);
		telaCompra.getBtDeslogar().addActionListener(compraController);

		navegador.adicionarPainel(LoginController.TELA_LOGIN, telaLogin);
		navegador.adicionarPainel(LoginController.TELA_CADASTRO_USUARIO, telaCadastroUsuarios);
		navegador.adicionarPainel(LoginController.TELA_CADASTRO_PRODUTOS, telaCadastroProdutos);
		navegador.adicionarPainel(LoginController.TELA_COMPRA, telaCompra);
		navegador.adicionarPainel(LoginController.TELA_NOTA_FISCAL, telaNotaFiscal);

		janela.setLocationRelativeTo(null);
		janela.setVisible(true);
		navegador.navegarPara(LoginController.TELA_LOGIN);
	}
}

