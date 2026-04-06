package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BancoDeDados {

    private static final String DEFAULT_URL = "jdbc:mysql://localhost:3306/mydb?useSSL=false&serverTimezone=UTC";
    private static final String DEFAULT_USUARIO = "root";
    private static final String DEFAULT_SENHA = "admin";
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";

    public static Connection conectar() {
        Connection conexao = null;
        try {
            Class.forName(DRIVER);
            String url = System.getProperty("DB_URL", DEFAULT_URL);
            String usuario = System.getProperty("DB_USER", DEFAULT_USUARIO);
            String senha = System.getProperty("DB_PASS", DEFAULT_SENHA);
            conexao = DriverManager.getConnection(url, usuario, senha);
        } catch (ClassNotFoundException e) {
            System.err.println("Driver JDBC não encontrado: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("Erro ao conectar ao banco de dados: " + e.getMessage());
        }
        return conexao;
    }

    public static void desconectar(Connection conexao) {
        if (conexao != null) {
            try {
                conexao.close();
            } catch (SQLException e) {
                System.err.println("Erro ao fechar a conexão: " + e.getMessage());
            }
        }
    }
}