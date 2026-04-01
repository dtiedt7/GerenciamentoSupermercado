package view;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;

public class TelaNotaFiscal extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel lbNome, lbCPF_NF, lbProdutos, lbTotalCompra;
	/**
	 * Create the panel.
	 */
	public TelaNotaFiscal() {
		setBackground(new Color(141, 141, 141));
		setLayout(new MigLayout("", "[grow][grow][grow]", "[grow][grow][grow][grow][grow][grow][grow][grow][grow][grow][grow]"));
		
		JLabel lblNewLabel = new JLabel("NOTA FISCAL");
		lblNewLabel.setForeground(new Color(225, 194, 19));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 40));
		add(lblNewLabel, "cell 1 1,alignx center");
		
		JLabel lbNome = new JLabel("Nome");
		lbNome.setForeground(new Color(225, 194, 19));
		lbNome.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(lbNome, "cell 1 3,alignx center");
		
		lbCPF_NF = new JLabel("CPF");
		lbCPF_NF.setForeground(new Color(225, 194, 19));
		lbCPF_NF.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(lbCPF_NF, "cell 1 5,alignx center");
//		add(lbCPF, "cell 1 5,alignx center");
		
		lbProdutos = new JLabel("Produtos");
		lbProdutos.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbProdutos.setForeground(new Color(225, 194, 19));
		add(lbProdutos, "cell 1 7,alignx center");
		
		lbTotalCompra = new JLabel("Total Compra");
		lbTotalCompra.setForeground(new Color(225, 194, 19));
		lbTotalCompra.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(lbTotalCompra, "cell 1 9,alignx center");

	}

}
