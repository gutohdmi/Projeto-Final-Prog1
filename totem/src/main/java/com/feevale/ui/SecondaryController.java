package com.feevale.ui;

import com.feevale.model.Pedido;
import com.feevale.model.PedidoStatus;
import com.feevale.service.PedidoController;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class SecondaryController {

    @FXML private ListView<String> listaAtendimentos;
    @FXML private TextField campoId;
    @FXML private ComboBox<PedidoStatus> comboStatus;

    private static PedidoController controller;

    public static void setController(PedidoController c) {
        controller = c;
    }

    @FXML
    public void initialize() {
        comboStatus.setItems(
                FXCollections.observableArrayList(PedidoStatus.values())
        );
        atualizarLista();
    }

    @FXML
    private void atualizarLista() {
        listaAtendimentos.getItems().clear();

        for (Pedido p : controller.listarAtendimentos()) {
            listaAtendimentos.getItems().add(
                    p.getIdAtendimento() + " | " +
                    p.getStatus() + " | R$ " +
                    p.calcularTotal()
            );
        }
    }

    @FXML
    private void atualizarStatus() {
        controller.atualizarStatus(
                campoId.getText(),
                comboStatus.getValue()
        );
        atualizarLista();
    }
}
