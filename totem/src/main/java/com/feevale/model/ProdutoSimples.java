package com.feevale.model;

public class ProdutoSimples extends Produto {

    public ProdutoSimples(String nome, double preco) {
        super(nome, preco);
    }

    @Override
    public String getDescricao() {
        return getNome();
    }
}
