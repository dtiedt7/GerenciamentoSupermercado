package view;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTable;

public class TelaCadastroProdutos extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField tfPreco;
	private JTextField tfProduto;
	private JTable table;
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public TelaCadastroProdutos() {
		setLayout(new MigLayout("", "[grow][grow][grow][grow 20][grow 50][grow][grow]", "[grow][grow][grow][grow][grow 80][grow][grow][grow][grow][grow][grow][::200,grow 50][grow][grow][grow]"));
		
		JLabel lbTitulo = new JLabel("Cadastro de Produtos");
		lbTitulo.setFont(new Font("Tahoma", Font.PLAIN, 40));
		add(lbTitulo, "cell 1 1 5 1,alignx center,growy");
		
		JLabel lbProdutos = new JLabel("Produto");
		lbProdutos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(lbProdutos, "cell 2 3,alignx center");
		
		tfProduto = new JTextField();
		tfProduto.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(tfProduto, "cell 4 3,growx");
		tfProduto.setColumns(10);
		
		JLabel lbPreco = new JLabel("Preço");
		lbPreco.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(lbPreco, "cell 2 5,alignx center");
		
		tfPreco = new JTextField();
		tfPreco.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(tfPreco, "cell 4 5,growx");
		tfPreco.setColumns(10);
		
		JLabel lbDescricao = new JLabel("Descrição");
		lbDescricao.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(lbDescricao, "cell 2 7,alignx center");
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(textField, "cell 4 7,growx");
		textField.setColumns(10);
		
		JButton btCadastrar = new JButton("Cadastrar");
		btCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(btCadastrar, "cell 3 9,alignx center");
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, "cell 2 11 3 1,grow");
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btEditar = new JButton("Editar");
		btEditar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(btEditar, "cell 2 13,alignx center");
		
		JButton btExcluir = new JButton("Excluir");
		btExcluir.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(btExcluir, "cell 4 13,alignx center");

	}

}
