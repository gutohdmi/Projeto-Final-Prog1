package com.feevale.ui;

import com.feevale.Repository.ProdutoRepository;
import com.feevale.model.Totem;
import com.feevale.service.PedidoController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        Totem totem = new Totem();
        ProdutoRepository repository = new ProdutoRepository();
        PedidoController controller = new PedidoController(totem, repository);

        PrimaryController.setDependencias(controller, repository);
        SecondaryController.setController(controller);

        FXMLLoader loaderCliente = new FXMLLoader(
                getClass().getResource("/com/feevale/cliente.fxml")
        );

        FXMLLoader loaderGestor = new FXMLLoader(
                getClass().getResource("/com/feevale/gestor.fxml")
        );

        TabPane tabs = new TabPane();

        tabs.getTabs().add(
                new Tab("Cliente", loaderCliente.load())
        );

        tabs.getTabs().add(
                new Tab("Gestor", loaderGestor.load())
        );

        Scene scene = new Scene(tabs, 900, 600);
        stage.setTitle("Quiosque de Autoatendimento");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
