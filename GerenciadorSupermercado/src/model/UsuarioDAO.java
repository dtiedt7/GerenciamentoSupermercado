package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.BancoDeDados;
import model.Usuario;

public class UsuarioDAO {
	// CREATE - Adicionar um novo usuário
    public void adicionarUsuario(Usuario usuario) {
        String sql = "INSERT INTO Usuarios (nome, CPF, senha, tipo) VALUES (?, ?, ?, ?)";
        Connection conexao = null;
        PreparedStatement pstm = null;

        try {
            conexao = database.BancoDeDados.conectar();
            pstm = conexao.prepareStatement(sql);
            pstm.setString(1, usuario.getNome());
            pstm.setString(2, usuario.getCPF());
            pstm.setString(3, usuario.getSenha());
            pstm.setBoolean(4, usuario.getAdmin());
            
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

    // READ - Listar todos os usuários
    public List<Usuario> listarUsuarios() {
        String sql = "SELECT id, nome, CPF, senha, tipo FROM Usuarios ORDER BY nome";
        List<Usuario> usuarios = new ArrayList<>();
        Connection conexao = null;
        PreparedStatement pstm = null;
        ResultSet rset = null;
        try {
            conexao = BancoDeDados.conectar();
            pstm = conexao.prepareStatement(sql);
            rset = pstm.executeQuery();

            while (rset.next()) {
                Usuario usuario = new Usuario();
                usuario.setId(rset.getInt("id"));
                usuario.setNome(rset.getString("nome"));
                usuario.setCPF(rset.getString("CPF"));
                usuario.setSenha(rset.getString("senha"));
                usuario.setAdmin(rset.getBoolean("tipo"));
                usuarios.add(usuario);
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
        return usuarios;
    }
    
    public Usuario buscarPorNomeECpf(String nome, String cpf) {
    	String sql = "SELECT id, nome, CPF, senha, tipo FROM Usuarios WHERE nome = ? AND CPF = ? LIMIT 1";
    	Connection conexao = null;
    	PreparedStatement pstm = null;
    	ResultSet rset = null;
    	try {
    		conexao = BancoDeDados.conectar();
    		pstm = conexao.prepareStatement(sql);
    		pstm.setString(1, nome);
    		pstm.setString(2, cpf);
    		rset = pstm.executeQuery();
    		if (rset.next()) {
    			Usuario usuario = new Usuario();
    			usuario.setId(rset.getInt("id"));
    			usuario.setNome(rset.getString("nome"));
    			usuario.setCPF(rset.getString("CPF"));
    			usuario.setSenha(rset.getString("senha"));
    			usuario.setAdmin(rset.getBoolean("tipo"));
    			return usuario;
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

    // UPDATE - Atualizar um usuário existente
    public void atualizarUsuario(Usuario usuario) {
        String sql = "UPDATE Usuarios SET nome = ?, CPF = ?, senha = ?, tipo = ? WHERE id = ?";
        Connection conexao = null;
        PreparedStatement pstm = null;

        try {
            conexao = BancoDeDados.conectar();
            pstm = conexao.prepareStatement(sql);
            pstm.setString(1, usuario.getNome());
            pstm.setString(2, usuario.getCPF());
            pstm.setString(3, usuario.getSenha());
            pstm.setBoolean(4, usuario.getAdmin());
            pstm.setInt(5, usuario.getId());
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

    // DELETE - Excluir um usuário pelo ID
    public void excluirUsuario(int id) {
        String sql = "DELETE FROM Usuarios WHERE id = ?";
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

