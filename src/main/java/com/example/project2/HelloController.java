package com.example.project2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController {
    @FXML
    private TextField gebruikersnaamTextfield;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Label foutmeldingLabel;

    private Stage stage;
    private Parent root;

    public void switchScene1(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("RegistratieScene.fxml"));
        root = loader.load();

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }

    public void switchScene2(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ChatScherm.fxml"));
        root = loader.load();

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }


    public void login(ActionEvent event) throws IOException {
        String gebruikersnaam = gebruikersnaamTextfield.getText();
        String wachtwoord = passwordField.getText();

        for (Gebruiker gebruiker : RegistratieController.getGebruikers()) {
            if (gebruiker.getGebruikersnaam().equals(gebruikersnaam) && gebruiker.getWachtwoord().equals(wachtwoord)) {
                foutmeldingLabel.setText("Login succesvol!");
                switchScene2(event); // Pass the event parameter here
                return;
            }
        }
        foutmeldingLabel.setText("Ongeldige gebruikersnaam of wachtwoord.");
    }

}
