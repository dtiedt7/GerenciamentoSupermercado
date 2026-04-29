package view;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;

import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JScrollPane;

public class TelaCadastroProdutos extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField tfProduto;
	private JTextField tfPreco;
	private JTextField tfDescricao;
	private JTextField tfEstoque;
	private JTable tabelaCadastroProduto;
	private JButton btAdicionar;
	private JButton btEditar;
	private JButton btRemover;
	private JButton btDeslogar;

	/**
	 * Create the panel.
	 * @throws IOException 
	 * @throws FontFormatException 
	 */
	public TelaCadastroProdutos() throws FontFormatException, IOException {
		setBackground(new Color(141, 141, 141));
		setLayout(new MigLayout("", "[grow][grow][grow][grow][grow]", "[grow70][grow70][grow70][grow70][grow70][grow70][grow70][grow70][grow70][grow70][grow70][grow][grow70][grow70][grow70]"));
		
		Font fonte = Font.createFont(
		        Font.TRUETYPE_FONT,
		        getClass().getResourceAsStream("/estilizacao/Jomhuria-Regular.ttf")
		).deriveFont(80f);
		Font fonte1 = Font.createFont(
		        Font.TRUETYPE_FONT,
		        getClass().getResourceAsStream("/estilizacao/Jomhuria-Regular.ttf")
		).deriveFont(40f);
		
		JLabel lbTitulo = new JLabel("Cadastro de Produtos");
		lbTitulo.setForeground(new Color(225, 194, 19));
		lbTitulo.setBackground(new Color(225, 194, 19));
		lbTitulo.setFont(fonte);
		add(lbTitulo, "cell 1 1 3 1,alignx center,growy");
		
		JLabel lblNewLabel = new JLabel("Produto");
		lblNewLabel.setForeground(new Color(225, 194, 19));
		lblNewLabel.setFont(fonte1);
		add(lblNewLabel, "cell 1 3,alignx right");
		
		tfProduto = new JTextField();
		tfProduto.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(tfProduto, "cell 3 3,growx");
		tfProduto.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Preço em R$");
		lblNewLabel_1.setForeground(new Color(225, 194, 19));
		lblNewLabel_1.setFont(fonte1);
		add(lblNewLabel_1, "cell 1 5,alignx right");
		
		tfPreco = new JTextField();
		tfPreco.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(tfPreco, "cell 3 5,growx");
		tfPreco.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Descrição");
		lblNewLabel_2.setForeground(new Color(225, 194, 19));
		lblNewLabel_2.setFont(fonte1);
		add(lblNewLabel_2, "cell 1 7,alignx right");
		
		tfDescricao = new JTextField();
		tfDescricao.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(tfDescricao, "cell 3 7,growx");
		tfDescricao.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Qtde. Estoque");
		lblNewLabel_3.setForeground(new Color(225, 194, 19));
		lblNewLabel_3.setFont(fonte1);
		add(lblNewLabel_3, "cell 1 9,alignx right");
		
		tfEstoque = new JTextField();
		tfEstoque.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(tfEstoque, "cell 3 9,growx");
		tfEstoque.setColumns(10);
		
		tabelaCadastroProduto = new JTable();
		tabelaCadastroProduto.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Produto", "Pre\u00E7o em R$", "Descri\u00E7\u00E3o", "Qtde. Estoque"
			}
		));
		JScrollPane scrollPane = new JScrollPane(tabelaCadastroProduto);
		add(scrollPane, "cell 1 11 3 1,grow");
		
		btAdicionar = new JButton("Adicionar");
		btAdicionar.setBackground(new Color(225, 194, 19));
		btAdicionar.setForeground(new Color(0, 0, 0));
		add(btAdicionar, "cell 1 13,alignx center,growy");
		btAdicionar.setFont(fonte1);
		
		btEditar = new JButton("Editar");
		btEditar.setBackground(new Color(225, 194, 19));
		add(btEditar, "cell 2 13,alignx center,growy");
		btEditar.setFont(fonte1);
		
		btRemover = new JButton("Remover");
		btRemover.setBackground(new Color(225, 194, 19));
		add(btRemover, "cell 3 13,alignx center,growy");
		btRemover.setFont(fonte1);
		
		btDeslogar = new JButton("Deslogar");
		btDeslogar.setBackground(new Color(225, 194, 19));
		add(btDeslogar, "cell 1 14,alignx left");
		btDeslogar.setFont(fonte1);

	}
	
	public JTextField getTfProduto() {
		return tfProduto;
	}
	
	public JTextField getTfPreco() {
		return tfPreco;
	}
	
	public JTextField getTfDescricao() {
		return tfDescricao;
	}
	
	public JTextField getTfEstoque() {
		return tfEstoque;
	}
	
	public JTable getTabelaCadastroProduto() {
		return tabelaCadastroProduto;
	}
	
	public JButton getBtAdicionar() {
		return btAdicionar;
	}
	
	public JButton getBtEditar() {
		return btEditar;
	}
	
	public JButton getBtRemover() {
		return btRemover;
	}
	
	public JButton getBtDeslogar() {
		return btDeslogar;
	}

}