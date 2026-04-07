package model;

import java.util.List;

public class NotaFiscalDAO {
	// CREATE - Criar uma nota fiscal (em memória)
	public NotaFiscal criarNotaFiscal(String nome, String cpf, List<ItemCarrinho> itens, float total) {
		return new NotaFiscal(nome, cpf, itens, total);
	}
}

