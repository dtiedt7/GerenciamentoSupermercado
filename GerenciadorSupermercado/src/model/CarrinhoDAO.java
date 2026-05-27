package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import database.BancoDeDados;

public class CarrinhoDAO {
    public Carrinho criarCarrinho() {
        return new Carrinho();
    }

    public void registrarItemCompra(int usuarioId, int produtoId, int quantidade, float precoUnitario) {
        String sql = "INSERT INTO Carrinho (usuario_id, produto_id, quantidade, preco_unitario) VALUES (?, ?, ?, ?)";
        Connection conexao = null;
        PreparedStatement pstm = null;

        try {
            conexao = BancoDeDados.conectar();
            pstm = conexao.prepareStatement(sql);
            pstm.setInt(1, usuarioId);
            pstm.setInt(2, produtoId);
            pstm.setInt(3, quantidade);
            pstm.setFloat(4, precoUnitario);
            pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BancoDeDados.desconectar(conexao);
            if (pstm != null) {
                try {
                    pstm.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
    public void removerProdutoDoCarrinho(int produtoId) {
        String sql = "DELETE FROM Carrinho WHERE produto_id = ?";

        Connection conexao = null;
        PreparedStatement pstm = null;

        try {
            conexao = BancoDeDados.conectar();

            pstm = conexao.prepareStatement(sql);
            pstm.setInt(1, produtoId);

            pstm.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BancoDeDados.desconectar(conexao);

            if (pstm != null) {
                try {
                    pstm.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void limparCarrinho(Carrinho carrinho) {
        if (carrinho != null) {
            carrinho.limpar();
        }
    }
}

