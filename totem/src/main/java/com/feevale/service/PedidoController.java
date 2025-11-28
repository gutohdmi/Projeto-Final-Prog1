package com.feevale.service;

import com.feevale.model.*;
import com.feevale.Repository.ProdutoRepository;
import java.util.List;

public class PedidoController {
    private Totem totem;
    private ProdutoRepository repo;

    public PedidoController(Totem totem, ProdutoRepository repo) {
        this.totem = totem;
        this.repo = repo;
    }

    public Pedido criarPedido() {
        return totem.novoPedido();
    }

    public void adicionarItem(Pedido pedido, String produtoId, int qtd) {
        Produto p = repo.buscarPorId(produtoId);
        if (p != null) pedido.adicionarItem(p, qtd);
    }

    public void removerItem(Pedido pedido, int index) {
        pedido.removerItem(index);
    }

    public void confirmarPedido(Pedido pedido) {
        totem.armazenarPedido(pedido);
    }

    public boolean atualizarStatus(String id, PedidoStatus status) {
        return totem.atualizarStatus(id, status);
    }

    public List<Pedido> listarAtendimentos() {
        return totem.listarAtendimentos();
    }
}
