package view;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.BorderLayout;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;

public class TelaCompra extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable tabelaProdutos;
	private JTable tabelaCarrinho;

	/**
	 * Create the panel.
	 */
	public TelaCompra() {
		setLayout(new MigLayout("", "[grow][grow][grow][grow][grow]", "[grow][grow][grow][grow][grow][grow][grow]"));
		
		JLabel lbTitulo = new JLabel("Compra");
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
				"Produto", "Pre\u00E7o"
			}
		));
		panel.add(tabelaProdutos, BorderLayout.CENTER);
		
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
				"Produto", "Quantidade"
			}
		));
		panel_1.add(tabelaCarrinho, BorderLayout.CENTER);
		
		JLabel lbTotalCompra = new JLabel("Total: R$0000.00");
		add(lbTotalCompra, "cell 3 4,alignx right");
		
		JButton btAdicionar = new JButton("Adicionar");
		add(btAdicionar, "cell 1 5,alignx center,growy");
		
		JButton btRemover = new JButton("Remover");
		add(btRemover, "cell 2 5,alignx center,growy");
		
		JButton btFinalizarCompra = new JButton("Finalizar Compra");
		add(btFinalizarCompra, "cell 3 5,alignx center,growy");

	}

}
