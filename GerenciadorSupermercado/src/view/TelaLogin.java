package view;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.FontFormatException;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Color;

// IMPORTS DA IMAGEM
import javax.swing.ImageIcon;
import java.awt.Image;

public class TelaLogin extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField tfUsuario;
	private JTextField tfCPF;
	private JButton btLogin, btCadastrarUsuario;
	private JLabel label;

	public TelaLogin() throws FontFormatException, IOException {
		setBackground(new Color(141, 141, 141));
		setLayout(new MigLayout("", "[grow][grow][grow 20][grow][grow]", "[grow][grow][grow][grow][grow][grow][grow][grow][grow]"));
		
		Font fonte = Font.createFont(
		        Font.TRUETYPE_FONT,
		        getClass().getResourceAsStream("/estilizacao/Jomhuria-Regular.ttf")
		).deriveFont(80f);
		Font fonte1 = Font.createFont(
		        Font.TRUETYPE_FONT,
		        getClass().getResourceAsStream("/estilizacao/Jomhuria-Regular.ttf")
		).deriveFont(35f);

		JLabel lblNewLabel = new JLabel("Tela Login");
		lblNewLabel.setForeground(new Color(225, 194, 19));
		lblNewLabel.setFont(fonte);
		add(lblNewLabel, "cell 1 1 2 1,alignx center,growy");
		

		label = new JLabel();

		ImageIcon icon = new ImageIcon(getClass().getResource("/estilizacao/LogoMercado.png"));
		Image img = icon.getImage().getScaledInstance(128, 128, Image.SCALE_SMOOTH);
		label.setIcon(new ImageIcon(img));
		
		add(label, "cell 3 1, alignx center");
		

		JLabel lblNewLabel_1 = new JLabel("Usuário");
		lblNewLabel_1.setForeground(new Color(225, 194, 19));
		lblNewLabel_1.setFont(fonte1);
		add(lblNewLabel_1, "cell 1 3,alignx center,growy");
		
		tfUsuario = new JTextField();
		tfUsuario.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(tfUsuario, "cell 3 3,growx");
		tfUsuario.setColumns(10);
		

		JLabel lblNewLabel_2 = new JLabel("CPF");
		lblNewLabel_2.setForeground(new Color(225, 194, 19));
		lblNewLabel_2.setFont(fonte1);
		add(lblNewLabel_2, "cell 1 5,alignx center,growy");
		
		tfCPF = new JTextField();
		tfCPF.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(tfCPF, "cell 3 5,growx");
		tfCPF.setColumns(10);
		
		btCadastrarUsuario = new JButton("Cadastrar");
		btCadastrarUsuario.setBackground(new Color(225, 194, 19));
		btCadastrarUsuario.setFont(fonte1);
		add(btCadastrarUsuario, "cell 1 7,alignx center");
		
		btLogin = new JButton("Logar");
		btLogin.setBackground(new Color(225, 194, 19));
		btLogin.setFont(fonte1);
		btLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		add(btLogin, "cell 3 7,growx");
	}
	
	public JTextField getTfUsuario() {
		return tfUsuario;
	}
	
	public JTextField getTfCPF() {
		return tfCPF;
	}
	
	public JButton getBtLogin() {
		return btLogin;
	}
	
	public JButton getBtCadastrarUsuario() {
		return btCadastrarUsuario;
	}
}