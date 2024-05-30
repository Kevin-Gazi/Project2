package com.example.project2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);

        // Krijg de controller van de geladen scene
        HelloController helloController = fxmlLoader.getController();

        // Maak het gedeelde model en stel het in op de controller
        GebruikerModel gebruikerModel = new GebruikerModel();
        helloController.setGebruikerModel(gebruikerModel);

        stage.setTitle("AI-Assistent");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
