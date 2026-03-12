package view;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaLogin extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField tfUsuario;
	private JTextField tfCPF;

	/**
	 * Create the panel.
	 */
	public TelaLogin() {
		setLayout(new MigLayout("", "[grow][grow][grow 20][grow 50][grow]", "[grow][grow][grow][grow][grow][grow][grow][grow][grow]"));
		
		JLabel lblNewLabel = new JLabel("Tela Login");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 40));
		add(lblNewLabel, "cell 1 1 3 1,alignx center,growy");
		
		JLabel lblNewLabel_1 = new JLabel("Usuário");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(lblNewLabel_1, "cell 1 3,alignx center,growy");
		
		tfUsuario = new JTextField();
		tfUsuario.setFont(new Font("Tahoma", Font.PLAIN, 12));
		add(tfUsuario, "cell 3 3,growx");
		tfUsuario.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("CPF");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(lblNewLabel_2, "cell 1 5,alignx center,growy");
		
		tfCPF = new JTextField();
		tfCPF.setFont(new Font("Tahoma", Font.PLAIN, 12));
		add(tfCPF, "cell 3 5,growx");
		tfCPF.setColumns(10);
		
		JButton btnNewButton = new JButton("Logar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		add(btnNewButton, "cell 2 7,growx");
		
	}

}
