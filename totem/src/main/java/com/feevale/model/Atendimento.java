package com.feevale.model;

import java.util.ArrayList;
import java.util.List;

public class Atendimento implements Pagavel {

    private static int contador = 1;

    private int numero;
    private List<Produto> itens;
    private StatusPedido status;

    public Atendimento() {
        this.numero = contador++;
        this.itens = new ArrayList<>();
        this.status = StatusPedido.EM_PREPARO;
    }

    public void adicionarProduto(Produto p) {
        itens.add(p);
    }

    public void removerProduto(Produto p) {
        itens.remove(p);
    }

    public List<Produto> getItens() {
        return itens;
    }

    public int getNumero() {
        return numero;
    }

    public StatusPedido getStatus() {
        return status;
    }

    public void setStatus(StatusPedido status) {
        this.status = status;
    }

    @Override
    public double calcularTotal() {
        double total = 0;
        for (Produto p : itens) {
            total += p.getPreco();
        }
        return total;
    }
}
