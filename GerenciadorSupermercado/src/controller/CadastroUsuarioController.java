package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.Supermercado;
import model.Usuario;
import view.TelaCadastroUsuarios;

public class CadastroUsuarioController implements ActionListener {
	private final TelaCadastroUsuarios tela;
	private final Supermercado supermercado;
	private final Navegador navegador;

	public CadastroUsuarioController(TelaCadastroUsuarios tela, Supermercado supermercado, Navegador navegador) {
		this.tela = tela;
		this.supermercado = supermercado;
		this.navegador = navegador;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		if (src == tela.getBtVoltar()) {
			navegador.navegarPara(LoginController.TELA_LOGIN);
			return;
		}
		if (src == tela.getBtCadastrar()) {
			String nome = tela.getTfUsuário().getText();
			String cpf = tela.getTfCPF().getText();
			String senha = new String(tela.getPfSenha().getPassword());
			boolean admin = tela.getRbAdministrador().isSelected();
			boolean cliente = tela.getRbCliente().isSelected();

			if (nome == null || nome.trim().isEmpty() || cpf == null || cpf.trim().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Informe nome e CPF.", "Erro", JOptionPane.ERROR_MESSAGE);
				return;
			}
			if (!admin && !cliente) {
				JOptionPane.showMessageDialog(null, "Selecione Cliente ou Administrador.", "Erro", JOptionPane.ERROR_MESSAGE);
				return;
			}
			if (senha == null || senha.trim().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Informe uma senha.", "Erro", JOptionPane.ERROR_MESSAGE);
				return;
			}

			supermercado.cadastrarUsuario(new Usuario(nome.trim(), cpf.trim(), admin, senha));
			JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso.");
			navegador.navegarPara(LoginController.TELA_LOGIN);
		}
	}
}

