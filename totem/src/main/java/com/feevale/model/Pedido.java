package com.feevale.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private String idAtendimento;
    private List<ItemPedido> itens = new ArrayList<>();
    private PedidoStatus status;
    private LocalDateTime dataHora;

    public Pedido(String idAtendimento) {
        this.idAtendimento = idAtendimento;
        this.status = PedidoStatus.EM_PREPARO;
        this.dataHora = LocalDateTime.now();
    }

    public String getIdAtendimento() { return idAtendimento; }
    public List<ItemPedido> getItens() { return itens; }
    public PedidoStatus getStatus() { return status; }
    public void setStatus(PedidoStatus status) { this.status = status; }

    public void adicionarItem(Produto p, int qtd) {
        itens.add(new ItemPedido(p, qtd));
    }

    public void removerItem(int index) {
        if (index >= 0 && index < itens.size()) itens.remove(index);
    }

    public double calcularTotal() {
        return itens.stream().mapToDouble(ItemPedido::getSubtotal).sum();
    }
}
