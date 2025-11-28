package com.feevale.payment;

import com.feevale.model.Pedido;

public interface IPagamento {
    boolean pagar(Pedido pedido, Object dadosPagamento);
}
