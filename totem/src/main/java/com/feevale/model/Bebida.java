package com.feevale.model;

public class Bebida extends Produto {

    public Bebida(String nome, double preco) {
        super(nome, preco);
    }

    @Override
    public String getDescricao() {
        return "Bebida: " + getNome();
    }
}
