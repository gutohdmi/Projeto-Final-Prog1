module com.feevale {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;

    opens com.feevale.ui to javafx.fxml;
    opens com.feevale.model to javafx.fxml;

    exports com.feevale.ui;
    exports com.feevale.model;
    exports com.feevale.service;
    exports com.feevale.Repository;
}