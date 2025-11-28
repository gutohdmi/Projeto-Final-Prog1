package com.feevale.Repository;

import com.feevale.model.Produto;
import com.feevale.model.ProdutoSimples;

import java.util.ArrayList;
import java.util.List;

public class ProdutoRepository {

    private List<Produto> produtos = new ArrayList<>();

    public ProdutoRepository() {
        produtos.add(new ProdutoSimples("Hambúrguer", 12.50));
        produtos.add(new ProdutoSimples("Batata Frita", 6.00));
        produtos.add(new ProdutoSimples("Refrigerante", 4.50));
    }

    public List<Produto> buscarTodos() {
        return new ArrayList<>(produtos);
    }
}
