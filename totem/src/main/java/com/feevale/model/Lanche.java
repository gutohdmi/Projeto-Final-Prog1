package com.feevale.model;

public class Lanche extends Produto {

    public Lanche(String nome, double preco) {
        super(nome, preco);
    }

    @Override
    public String getDescricao() {
        return "Lanche: " + getNome();
    }
}
