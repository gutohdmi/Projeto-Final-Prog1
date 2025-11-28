package com.feevale.ui;

import com.feevale.Repository.ProdutoRepository;
import com.feevale.model.Atendimento;
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

    private Atendimento atendimentoAtual;
    private static PedidoController controller;
    private static ProdutoRepository repository;

    public static void setDependencias(PedidoController c, ProdutoRepository r) {
        controller = c;
        repository = r;
    }

    @FXML
    public void initialize() {
        comboProdutos.setItems(
                FXCollections.observableArrayList(repository.buscarTodos())
        );

        atendimentoAtual = controller.novoAtendimento();
        atualizarLista();
    }

    @FXML
    private void adicionarItem() {
        Produto p = comboProdutos.getValue();

        if (p != null) {
            controller.adicionarProduto(p);
            atualizarLista();
        }
    }

    @FXML
    private void removerItem() {
        int index = listaPedido.getSelectionModel().getSelectedIndex();

        if (index >= 0) {
            Produto p = atendimentoAtual.getItens().get(index);
            controller.removerProduto(p);
            atualizarLista();
        }
    }

    @FXML
    private void confirmarPedido() {
        int numero = controller.confirmarPedido();

        Alert alert = new Alert(Alert.AlertType.INFORMATION,
                "Pedido confirmado!\nNúmero: " + numero);
        alert.showAndWait();

        atendimentoAtual = controller.novoAtendimento();
        atualizarLista();
    }

    private void atualizarLista() {
        listaPedido.getItems().clear();

        atendimentoAtual.getItens().forEach(produto -> {
            listaPedido.getItems().add(
                    produto.getNome() + " - R$ " + produto.getPreco()
            );
        });

        labelTotal.setText("Total: R$ " + atendimentoAtual.calcularTotal());
    }
}
