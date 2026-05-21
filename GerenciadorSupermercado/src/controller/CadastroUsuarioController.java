package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.Usuario;
import model.UsuarioDAO;
import view.TelaCadastroUsuarios;

public class CadastroUsuarioController implements ActionListener {
	private final TelaCadastroUsuarios tela;
	private final UsuarioDAO usuarioDAO;
	private final Navegador navegador;

	public CadastroUsuarioController(TelaCadastroUsuarios tela, UsuarioDAO usuarioDAO, Navegador navegador) {
		this.tela = tela;
		this.usuarioDAO = usuarioDAO;
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
			String nome = tela.getTfUsuario().getText();
			String cpf = tela.getCPF();
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
			if (cpf.length() >11 || cpf.length()<11) {
				JOptionPane.showMessageDialog(null, "CPF deve ter 11 digitos.", "Erro", JOptionPane.ERROR_MESSAGE);
				return;
			}

			try {

			    usuarioDAO.adicionarUsuario(
			        new Usuario(nome.trim(), cpf.trim(), admin, senha)
			    );

			    JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso."
			    );

			    navegador.navegarPara(LoginController.TELA_LOGIN);

			} catch (RuntimeException ex) {

			    JOptionPane.showMessageDialog(null, ex.getMessage(),"Erro", JOptionPane.ERROR_MESSAGE
			    );
			}
		}
	}
}

