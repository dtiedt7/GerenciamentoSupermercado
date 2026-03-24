package view;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import java.awt.Font;

public class TelaNotaFiscal extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public TelaNotaFiscal() {
		setLayout(new MigLayout("", "[grow][grow][grow]", "[grow][grow][grow][grow][grow][grow][grow][grow][grow][grow][grow]"));
		
		JLabel lblNewLabel = new JLabel("NOTA FISCAL");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(lblNewLabel, "cell 1 1,alignx center");
		
		JLabel lbNome = new JLabel("Nome");
		add(lbNome, "cell 1 3,alignx center");
		
		JLabel lbCPF = new JLabel("CPF");
		
		JLabel lbCPF_NF = new JLabel("CPF");
		add(lbCPF_NF, "cell 1 5,alignx center");
//		add(lbCPF, "cell 1 5,alignx center");
		
		JLabel lbProdutos = new JLabel("Produtos");
		add(lbProdutos, "cell 1 7,alignx center");
		
		JLabel lbTotalCompra = new JLabel("Total Compra");
		add(lbTotalCompra, "cell 1 9,alignx center");

	}

}
