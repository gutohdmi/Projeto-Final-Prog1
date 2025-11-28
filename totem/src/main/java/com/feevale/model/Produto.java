package com.feevale.model;

public abstract class Produto {

    private String nome;
    private double preco;
    
    public Produto(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    @Override
    public String toString() {
        return nome + " - R$ " + String.format("%.2f", preco);
    }

    public abstract String getDescricao();

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }
}
