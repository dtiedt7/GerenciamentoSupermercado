package model;

import java.util.List;

public class SupermercadoDAO {
	// CREATE - Criar um supermercado com seus DAOs
	public Supermercado criarSupermercado() {
		return new Supermercado(new UsuarioDAO(), new ProdutoDAO());
	}

	// READ - Login do usuário
	public Usuario login(Supermercado supermercado, String nome, String cpf) {
		return supermercado == null ? null : supermercado.login(nome, cpf);
	}

	// CREATE - Cadastrar usuário
	public void cadastrarUsuario(Supermercado supermercado, Usuario usuario) {
		if (supermercado != null) {
			supermercado.cadastrarUsuario(usuario);
		}
	}

	// READ - Listar produtos
	public List<Produto> listarProdutos(Supermercado supermercado) {
		return supermercado == null ? null : supermercado.listarProdutos();
	}
}

