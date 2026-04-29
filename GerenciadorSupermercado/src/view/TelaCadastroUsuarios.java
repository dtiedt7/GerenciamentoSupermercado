package view;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;

import javax.swing.JButton;
import java.awt.Color;
import javax.swing.ButtonGroup;
import javax.swing.JPasswordField;

public class TelaCadastroUsuarios extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField tfUsuário;
	private JTextField tfCPF;
	private JPasswordField pfSenha;
	private JButton btCadastrar, btVoltar;
	private JRadioButton rbAdministrador, rbCliente;
	private final ButtonGroup grupoTipo = new ButtonGroup();

	/**
	 * Create the panel.
	 * @throws IOException 
	 * @throws FontFormatException 
	 */
	public TelaCadastroUsuarios() throws FontFormatException, IOException {
		setBackground(new Color(141, 141, 141));
		setLayout(new MigLayout("", "[grow][grow][grow][grow][grow]", "[grow][grow][grow][grow][grow][grow][grow][grow][grow][grow]"));
		
		Font fonte = Font.createFont(
		        Font.TRUETYPE_FONT,
		        getClass().getResourceAsStream("/estilizacao/Jomhuria-Regular.ttf")
		).deriveFont(80f);
		Font fonte1 = Font.createFont(
		        Font.TRUETYPE_FONT,
		        getClass().getResourceAsStream("/estilizacao/Jomhuria-Regular.ttf")
		).deriveFont(40f);
		
		JLabel lbTitulo = new JLabel("Tela Cadastro");
		lbTitulo.setForeground(new Color(225, 194, 19));
		lbTitulo.setBackground(new Color(225, 194, 19));
		lbTitulo.setFont(fonte);
		add(lbTitulo, "cell 1 1 3 1,alignx center,growy");
		
		JLabel lbUsuario = new JLabel("Usuário");
		lbUsuario.setForeground(new Color(225, 194, 19));
		lbUsuario.setFont(fonte1);
		add(lbUsuario, "cell 1 3,alignx center,growy");
		
		tfUsuário = new JTextField();
		tfUsuário.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(tfUsuário, "cell 3 3,growx");
		tfUsuário.setColumns(10);
		
		JLabel lbCPF = new JLabel("CPF");
		lbCPF.setForeground(new Color(225, 194, 19));
		lbCPF.setFont(fonte1);
		add(lbCPF, "cell 1 4,alignx center,growy");
		
		tfCPF = new JTextField();
		tfCPF.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(tfCPF, "cell 3 4,growx");
		tfCPF.setColumns(10);
		
		JLabel lbSenha = new JLabel("Senha");
		lbSenha.setForeground(new Color(225, 194, 19));
		lbSenha.setFont(fonte1);
		add(lbSenha, "cell 1 5,alignx center,growy");
		
		pfSenha = new JPasswordField();
		pfSenha.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(pfSenha, "cell 3 5,growx");
		
		rbCliente = new JRadioButton("Cliente");
		rbCliente.setForeground(new Color(225, 194, 19));
		rbCliente.setFont(fonte1);
		grupoTipo.add(rbCliente);
		rbCliente.setOpaque(false);
		rbCliente.setBorderPainted(false);
		add(rbCliente, "cell 1 6,alignx center");
		
		rbAdministrador = new JRadioButton("Administrador");
		rbAdministrador.setForeground(new Color(225, 194, 19));
		rbAdministrador.setFont(fonte1);
		grupoTipo.add(rbAdministrador);
		rbAdministrador.setOpaque(false);
		rbAdministrador.setBorderPainted(false);
		add(rbAdministrador, "cell 3 6,alignx center");
		
		btVoltar = new JButton("Tela de Login");
		btVoltar.setBackground(new Color(225, 194, 19));
		btVoltar.setFont(fonte1);
		btVoltar.setOpaque(true);
		btVoltar.setBorderPainted(false);
		add(btVoltar, "cell 1 8,alignx center");
		
		btCadastrar = new JButton("Cadastrar Usuário");
		btCadastrar.setBackground(new Color(225, 194, 19));
		btCadastrar.setFont(fonte1);
		btCadastrar.setOpaque(true);
		btCadastrar.setBorderPainted(false);
		add(btCadastrar, "cell 3 8,growx");

	}
	
	public JTextField getTfUsuário() {
		return tfUsuário;
	}
	
	public JTextField getTfCPF() {
		return tfCPF;
	}
	
	public JPasswordField getPfSenha() {
		return pfSenha;
	}
	
	public JButton getBtCadastrar() {
		return btCadastrar;
	}
	
	public JButton getBtVoltar() {
		return btVoltar;
	}
	
	public JRadioButton getRbAdministrador() {
		return rbAdministrador;
	}
	
	public JRadioButton getRbCliente() {
		return rbCliente;
	}

}