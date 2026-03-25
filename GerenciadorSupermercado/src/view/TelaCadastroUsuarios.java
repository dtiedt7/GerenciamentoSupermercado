package view;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;

public class TelaCadastroUsuarios extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField tfUsuário;
	private JTextField tfCPF;

	/**
	 * Create the panel.
	 */
	public TelaCadastroUsuarios() {
		setBackground(new Color(141, 141, 141));
		setLayout(new MigLayout("", "[grow][grow][grow][grow][grow]", "[grow][grow][grow][grow][grow][grow][grow][grow][grow][grow][grow]"));
		
		JLabel lbTitulo = new JLabel("Tela Cadastro");
		lbTitulo.setForeground(new Color(225, 194, 19));
		lbTitulo.setBackground(new Color(225, 194, 19));
		lbTitulo.setFont(new Font("Tahoma", Font.PLAIN, 40));
		add(lbTitulo, "cell 1 1 3 1,alignx center,growy");
		
		JLabel lbUsuario = new JLabel("Usuário");
		lbUsuario.setForeground(new Color(225, 194, 19));
		lbUsuario.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(lbUsuario, "cell 1 3,alignx center,growy");
		
		tfUsuário = new JTextField();
		tfUsuário.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(tfUsuário, "cell 3 3,growx");
		tfUsuário.setColumns(10);
		
		JLabel lbCPF = new JLabel("CPF");
		lbCPF.setForeground(new Color(225, 194, 19));
		lbCPF.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(lbCPF, "cell 1 5,alignx center,growy");
		
		tfCPF = new JTextField();
		tfCPF.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(tfCPF, "cell 3 5,growx");
		tfCPF.setColumns(10);
		
		JRadioButton rbCliente = new JRadioButton("Cliente");
		rbCliente.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(rbCliente, "cell 1 7,alignx center");
		
		JRadioButton rbAdministrador = new JRadioButton("Administrador");
		rbAdministrador.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(rbAdministrador, "cell 3 7,alignx center");
		
		JButton btVoltar = new JButton("Tela de Login");
		btVoltar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(btVoltar, "cell 1 9,alignx center");
		
		JButton btCadastrar = new JButton("Cadastrar Usuário");
		btCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(btCadastrar, "cell 3 9,growx");

	}

}
