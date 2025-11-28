package com.feevale.ui;

import com.feevale.Repository.ProdutoRepository;
import com.feevale.model.Pedido;
import com.feevale.model.Produto;
import com.feevale.service.PedidoController;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class PrimaryController {

    @FXML private ComboBox<Produto> comboProdutos;
    @FXML private Spinner<Integer> spinnerQtd;
    @FXML private ListView<String> listaPedido;
    @FXML private Label labelTotal;

    private Pedido pedidoAtual;
    private static PedidoController controller;
    private static ProdutoRepository repository;

    // Injetado pelo App.java
    public static void setDependencias(PedidoController c, ProdutoRepository r) {
        controller = c;
        repository = r;
    }

    @FXML
    public void initialize() {
        comboProdutos.setItems(
                FXCollections.observableArrayList(repository.buscarTodos())
        );

        spinnerQtd.setValueFactory(
                new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 20, 1)
        );

        pedidoAtual = controller.criarPedido();
        atualizarLista();
    }

    @FXML
    private void adicionarItem() {
        Produto p = comboProdutos.getValue();
        int qtd = spinnerQtd.getValue();

        if (p != null) {
            pedidoAtual.adicionarItem(p, qtd);
            atualizarLista();
        }
    }

    @FXML
    private void removerItem() {
        int index = listaPedido.getSelectionModel().getSelectedIndex();
        if (index >= 0) {
            pedidoAtual.removerItem(index);
            atualizarLista();
        }
    }

    @FXML
    private void confirmarPedido() {
        controller.confirmarPedido(pedidoAtual);

        Alert alert = new Alert(Alert.AlertType.INFORMATION,
                "Pedido confirmado!\nNúmero: " + pedidoAtual.getIdAtendimento());
        alert.showAndWait();

        pedidoAtual = controller.criarPedido();
        atualizarLista();
    }

    private void atualizarLista() {
        listaPedido.getItems().clear();
        pedidoAtual.getItens().forEach(item -> {
            listaPedido.getItems().add(
                    item.getProduto().getNome() + " x" +
                    item.getQuantidade() + " = R$ " +
                    item.getSubtotal()
            );
        });

        labelTotal.setText("Total: R$ " + pedidoAtual.calcularTotal());
    }
}
