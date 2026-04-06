package view;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.BorderLayout;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JScrollPane;

public class TelaCompra extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable tabelaProdutos;
	private JTable tabelaCarrinho;
	private JButton btRemover, btAdicionar, btFinalizarCompra;
	private JButton btDeslogar;
	private JLabel lbTotalCompra;

	/**
	 * Create the panel.
	 */
	public TelaCompra() {
		setBackground(new Color(141, 141, 141));
		setLayout(new MigLayout("", "[grow][grow][grow][grow][grow]", "[grow][grow][grow][grow][grow][grow][grow]"));
		
		JLabel lbTitulo = new JLabel("Compra");
		lbTitulo.setForeground(new Color(225, 194, 19));
		lbTitulo.setFont(new Font("Tahoma", Font.PLAIN, 40));
		add(lbTitulo, "cell 1 1 3 1,alignx center,growy");
		
		JPanel panel = new JPanel();
		add(panel, "cell 1 3,grow");
		panel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("Produtos");
		panel.add(lblNewLabel, BorderLayout.NORTH);
		
		tabelaProdutos = new JTable();
		tabelaProdutos.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Produto", "Pre\u00E7o", "Estoque"
			}
		));
		panel.add(new JScrollPane(tabelaProdutos), BorderLayout.CENTER);
		
		JPanel panel_1 = new JPanel();
		add(panel_1, "cell 3 3,grow");
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_1 = new JLabel("Carrinho");
		panel_1.add(lblNewLabel_1, BorderLayout.NORTH);
		
		tabelaCarrinho = new JTable();
		tabelaCarrinho.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Produto", "Quantidade", "Subtotal"
			}
		));
		panel_1.add(new JScrollPane(tabelaCarrinho), BorderLayout.CENTER);
		
		lbTotalCompra = new JLabel("Total: R$ 0.00");
		lbTotalCompra.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbTotalCompra.setForeground(new Color(225, 194, 19));
		add(lbTotalCompra, "cell 3 4,alignx right");
		
		btAdicionar = new JButton("Adicionar");
		add(btAdicionar, "cell 1 5,alignx center,growy");
		
		btRemover = new JButton("Remover");
		add(btRemover, "cell 2 5,alignx center,growy");
		
		btFinalizarCompra = new JButton("Finalizar Compra");
		add(btFinalizarCompra, "cell 3 5,alignx center,growy");
		
		btDeslogar = new JButton("Deslogar");
		add(btDeslogar, "cell 1 6,alignx left");

	}
	
	public JTable getTabelaProdutos() {
		return tabelaProdutos;
	}
	
	public JTable getTabelaCarrinho() {
		return tabelaCarrinho;
	}
	
	public JButton getBtRemover() {
		return btRemover;
	}
	
	public JButton getBtAdicionar() {
		return btAdicionar;
	}
	
	public JButton getBtFinalizarCompra() {
		return btFinalizarCompra;
	}
	
	public JButton getBtDeslogar() {
		return btDeslogar;
	}
	
	public JLabel getLbTotalCompra() {
		return lbTotalCompra;
	}

}
