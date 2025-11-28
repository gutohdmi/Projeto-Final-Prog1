package com.feevale.model;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Totem {
    private List<Pedido> atendimentos = new ArrayList<>();
    private AtomicInteger geradorId = new AtomicInteger(1);

    public Pedido novoPedido() {
        String id = String.format("AT-%05d", geradorId.getAndIncrement());
        Pedido p = new Pedido(id);
        return p;
    }

    public void armazenarPedido(Pedido pedido) {
        atendimentos.add(pedido);
    }

    public List<Pedido> listarAtendimentos() {
        return new ArrayList<>(atendimentos);
    }

    public boolean atualizarStatus(String id, PedidoStatus novoStatus) {
        return atendimentos.stream()
            .filter(p -> p.getIdAtendimento().equals(id))
            .findFirst()
            .map(p -> { p.setStatus(novoStatus); return true; })
            .orElse(false);
    }
}
