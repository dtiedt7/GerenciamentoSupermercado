package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Carrinho {
    public static class Item {
        private final Produto produto;
        private int quantidade;

        public Item(Produto produto, int quantidade) {
            this.produto = produto;
            this.quantidade = quantidade;
        }

        public Produto getProduto() {
            return produto;
        }

        public int getQuantidade() {
            return quantidade;
        }

        public void setQuantidade(int quantidade) {
            this.quantidade = quantidade;
        }

        public float getSubtotal() {
            return produto.getPreco() * quantidade;
        }
    }

    private final List<Item> itens = new ArrayList<>();

    public List<Item> getItens() {
        return Collections.unmodifiableList(itens);
    }

    public void limpar() {
        itens.clear();
    }

    public void adicionar(Produto produto, int quantidade) {
        if (produto == null || quantidade <= 0) {
            return;
        }
        for (Item item : itens) {
            if (item.getProduto().getId() == produto.getId()) {
                item.setQuantidade(item.getQuantidade() + quantidade);
                return;
            }
        }
        itens.add(new Item(produto, quantidade));
    }

    public void removerPorId(int produtoId, int quantidade) {
        if (quantidade <= 0) {
            return;
        }
        for (int i = 0; i < itens.size(); i++) {
            Item item = itens.get(i);
            if (item.getProduto().getId() == produtoId) {
                int novo = item.getQuantidade() - quantidade;
                if (novo <= 0) {
                    itens.remove(i);
                } else {
                    item.setQuantidade(novo);
                }
                return;
            }
        }
    }

    public float getTotal() {
        float total = 0f;
        for (Item item : itens) {
            total += item.getSubtotal();
        }
        return total;
    }

    public boolean isVazio() {
        return itens.isEmpty();
    }
}

