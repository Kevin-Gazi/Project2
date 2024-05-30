package com.example.project2;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Aanmelden {
    private Stage stage;
    private Parent root;

    public void switchScene(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("RegistratieScene.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }
}