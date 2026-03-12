package view;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaCadastroUsuario extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField tfNome;
	private JTextField tfCPF;

	/**
	 * Create the panel.
	 */
	public TelaCadastroUsuario() {
		setLayout(new MigLayout("", "[grow][grow][grow][grow][grow][grow][grow]", "[grow][grow][grow][grow][grow][grow][grow][grow][grow][grow][grow]"));
		
		JLabel lbTitulo = new JLabel("Cadastro de Usuários");
		lbTitulo.setFont(new Font("Tahoma", Font.PLAIN, 40));
		add(lbTitulo, "cell 1 1 5 1,alignx center,aligny center");
		
		JLabel lbNome = new JLabel("NOME");
		add(lbNome, "cell 2 3,alignx center");
		
		tfNome = new JTextField();
		add(tfNome, "cell 4 3,growx");
		tfNome.setColumns(10);
		
		JLabel lbCPF = new JLabel("CPF");
		add(lbCPF, "cell 2 5,alignx center");
		
		tfCPF = new JTextField();
		add(tfCPF, "cell 4 5,growx");
		tfCPF.setColumns(10);
		
		JRadioButton rdAdministrador = new JRadioButton("Administrador");
		add(rdAdministrador, "cell 2 7,alignx center");
		
		JRadioButton rdCliente = new JRadioButton("Cliente");
		add(rdCliente, "cell 4 7,alignx center");
		
		JButton btConfirma = new JButton("Confirmar");
		btConfirma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		add(btConfirma, "cell 2 9,alignx center");
		
		JButton btTelaLogin = new JButton("Tela Login");
		add(btTelaLogin, "cell 4 9,alignx center");

	}

}
