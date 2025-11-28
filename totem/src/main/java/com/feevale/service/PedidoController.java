package com.feevale.service;

import com.feevale.model.Atendimento;
import com.feevale.model.Produto;
import com.feevale.model.StatusPedido;
import com.feevale.model.Totem;
import com.feevale.Repository.ProdutoRepository;
import java.util.List;


public class PedidoController {

    private Atendimento atendimentoAtual;
    private Totem totem;
    private ProdutoRepository repository;

    public PedidoController(Totem totem, ProdutoRepository repository) {
        this.totem = totem;
        this.repository = repository;
        this.atendimentoAtual = new Atendimento();
    }

    public void adicionarProduto(Produto p) {
        atendimentoAtual.adicionarProduto(p);
    }

    public void removerProduto(Produto p) {
        atendimentoAtual.removerProduto(p);
    }

    public double getTotal() {
        return atendimentoAtual.calcularTotal();
    }
    

    public int confirmarPedido() {
        totem.registrarAtendimento(atendimentoAtual);
        int numero = atendimentoAtual.getNumero();
        atendimentoAtual = new Atendimento(); // novo pedido
        return numero;
    }


    public void atualizarStatus(Atendimento atendimento, StatusPedido status) {
        atendimento.setStatus(status);
    }
    public Atendimento novoAtendimento() {
        return atendimentoAtual;
    }
    
    public List<Atendimento> listarAtendimentos() {
        return totem.getAtendimentos();
    }
    
}
