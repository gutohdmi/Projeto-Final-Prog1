package com.feevale.ui;

import com.feevale.model.Atendimento;
import com.feevale.model.StatusPedido;
import com.feevale.service.PedidoController;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class SecondaryController {

    @FXML private ListView<String> listaAtendimentos;
    @FXML private ComboBox<StatusPedido> comboStatus;

    private static PedidoController controller;

    public static void setController(PedidoController c) {
        controller = c;
    }

    @FXML
    public void initialize() {
        comboStatus.setItems(
                FXCollections.observableArrayList(StatusPedido.values())
        );
        atualizarLista();
    }

    @FXML
    private void atualizarLista() {
        listaAtendimentos.getItems().clear();

        for (Atendimento a : controller.listarAtendimentos()) {
            listaAtendimentos.getItems().add(
                    "Atendimento " + a.getNumero() + " | " +
                    a.getStatus() + " | R$ " +
                    a.calcularTotal()
            );
        }
    }

    @FXML
    private void atualizarStatus() {
        int index = listaAtendimentos.getSelectionModel().getSelectedIndex();

        if (index >= 0) {
            Atendimento atendimento = controller.listarAtendimentos().get(index);
            controller.atualizarStatus(atendimento, comboStatus.getValue());
            atualizarLista();
        }
    }
}
