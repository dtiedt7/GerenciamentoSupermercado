package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.BancoDeDados;

public class ProdutoDAO {
    public void adicionarProduto(Produto produto) {
        String sql = "INSERT INTO Produtos (nome_produto, preco, qtde_estoque, descricao) VALUES (?, ?, ?, ?)";
        Connection conexao = null;
        PreparedStatement pstm = null;

        try {
            conexao = database.BancoDeDados.conectar();
            pstm = conexao.prepareStatement(sql);
            pstm.setString(1, produto.getNome_produto());
            pstm.setFloat(2, produto.getPreco());
            pstm.setInt(3, produto.getQtde_estoque());
            pstm.setString(4, produto.getDescricao());
            
            pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        	database.BancoDeDados.desconectar(conexao);
            if (pstm != null) {
                try {
                    pstm.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public List<Produto> listarProdutos() {
        String sql = "SELECT id, nome_produto, preco, qtde_estoque, descricao FROM Produtos ORDER BY nome_produto";
        List<Produto> produtos = new ArrayList<>();
        Connection conexao = null;
        PreparedStatement pstm = null;
        ResultSet rset = null;
        try {
            conexao = BancoDeDados.conectar();
            pstm = conexao.prepareStatement(sql);
            rset = pstm.executeQuery();

            while (rset.next()) {
                Produto produto = new Produto();
                produto.setId(rset.getInt("id"));
                produto.setNome_produto(rset.getString("nome_produto"));
                produto.setPreco(rset.getFloat("preco"));
                produto.setQtde_estoque(rset.getInt("qtde_estoque"));
                produto.setDescricao(rset.getString("descricao"));
                produtos.add(produto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        	BancoDeDados.desconectar(conexao);
            if (rset != null) {
            	try { rset.close(); } catch (SQLException e) { e.printStackTrace(); }
            }
            if (pstm != null) {
            	try { pstm.close(); } catch (SQLException e) { e.printStackTrace(); }
            }
        }
        return produtos;
    }

    public void atualizarProduto(Produto produto) {
        String sql = "UPDATE Produtos SET nome_produto = ?, preco = ?, qtde_estoque = ?, descricao = ? WHERE id = ?";
        Connection conexao = null;
        PreparedStatement pstm = null;

        try {
            conexao = BancoDeDados.conectar();
            pstm = conexao.prepareStatement(sql);
            pstm.setString(1, produto.getNome_produto());
            pstm.setFloat(2, produto.getPreco());
            pstm.setInt(3, produto.getQtde_estoque());
            pstm.setString(4, produto.getDescricao());
            pstm.setInt(5, produto.getId());
            pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        	BancoDeDados.desconectar(conexao);
            if (pstm != null) {
            	try { pstm.close(); } catch (SQLException e) { e.printStackTrace(); }
            }
        }
    }
    
    public void atualizarEstoque(int idProduto, int novoEstoque) {
    	String sql = "UPDATE Produtos SET qtde_estoque = ? WHERE id = ?";
    	Connection conexao = null;
    	PreparedStatement pstm = null;
    	try {
    		conexao = BancoDeDados.conectar();
    		pstm = conexao.prepareStatement(sql);
    		pstm.setInt(1, novoEstoque);
    		pstm.setInt(2, idProduto);
    		pstm.executeUpdate();
    	} catch (SQLException e) {
    		e.printStackTrace();
    	} finally {
    		BancoDeDados.desconectar(conexao);
            if (pstm != null) {
            	try { pstm.close(); } catch (SQLException e) { e.printStackTrace(); }
            }
    	}
    }
    
    public Produto buscarPorId(int id) {
    	String sql = "SELECT id, nome_produto, preco, qtde_estoque, descricao FROM Produtos WHERE id = ?";
    	Connection conexao = null;
    	PreparedStatement pstm = null;
    	ResultSet rset = null;
    	try {
    		conexao = BancoDeDados.conectar();
    		pstm = conexao.prepareStatement(sql);
    		pstm.setInt(1, id);
    		rset = pstm.executeQuery();
    		if (rset.next()) {
    			Produto produto = new Produto();
    			produto.setId(rset.getInt("id"));
    			produto.setNome_produto(rset.getString("nome_produto"));
    			produto.setPreco(rset.getFloat("preco"));
    			produto.setQtde_estoque(rset.getInt("qtde_estoque"));
    			produto.setDescricao(rset.getString("descricao"));
    			return produto;
    		}
    	} catch (SQLException e) {
    		e.printStackTrace();
    	} finally {
    		BancoDeDados.desconectar(conexao);
            if (rset != null) {
            	try { rset.close(); } catch (SQLException e) { e.printStackTrace(); }
            }
            if (pstm != null) {
            	try { pstm.close(); } catch (SQLException e) { e.printStackTrace(); }
            }
    	}
    	return null;
    }

    public void excluirProduto(int id) {
        String sql = "DELETE FROM Produtos WHERE id = ?";
        Connection conexao = null;
        PreparedStatement pstm = null;

        try {
            conexao = BancoDeDados.conectar();
            pstm = conexao.prepareStatement(sql);
            pstm.setInt(1, id);
            pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        	BancoDeDados.desconectar(conexao);
            if (pstm != null) {
            	try { pstm.close(); } catch (SQLException e) { e.printStackTrace(); }
            }
        }
    }
}

