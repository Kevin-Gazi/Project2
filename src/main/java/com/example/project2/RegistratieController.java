package com.example.project2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class RegistratieController extends Registratie {
    private GebruikerModel gebruikerModel;

    @FXML
    private TextField gebruikersnaamRegistratie;
    @FXML
    private PasswordField wachtwoordRegistratie;
    @FXML
    private TextField emailRegistratie;
    @FXML
    private Button registratieButton;
    private Stage stage;
    private Parent root;

    public void setGebruikerModel(GebruikerModel gebruikerModel) {
        this.gebruikerModel = gebruikerModel;
    }

    @Override
    boolean checkVelden() {
        String gebruikersnaam = gebruikersnaamRegistratie.getText();
        String wachtwoord = wachtwoordRegistratie.getText();
        String email = emailRegistratie.getText();

        if (gebruikersnaam.isEmpty() || wachtwoord.isEmpty() || email.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Vul alle velden in.");
            alert.show();
            return false;
        }
        return true;
    }

    @Override
    boolean checkGebruikersnaam() {
        String gebruikersnaam = gebruikersnaamRegistratie.getText();
        for (Gebruiker gebruiker : gebruikerModel.getGebruikers()) {
            if (gebruiker.getGebruikersnaam().equals(gebruikersnaam)) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Gebruikersnaam is al in gebruik.");
                alert.show();
                return false;
            }
        }
        return true;
    }

    @Override
    boolean checkWachtwoord() {
        String wachtwoord = wachtwoordRegistratie.getText();
        if (wachtwoord.length() < 6) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Wachtwoord moet minimaal 6 tekens lang zijn.");
            alert.show();
            return false;
        }
        return true;
    }

    @Override
    void voegGebruikerToe(ActionEvent event) {
        String gebruikersnaam = gebruikersnaamRegistratie.getText();
        String wachtwoord = wachtwoordRegistratie.getText();
        String email = emailRegistratie.getText();

        Gebruiker gebruiker = new Gebruiker(gebruikersnaam, wachtwoord, email);
        gebruikerModel.voegGebruikerToe(gebruiker);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("Gebruiker succesvol geregistreerd.");
        alert.show();
        try {
            switchToLogin(event);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void Registreren(ActionEvent event){
        super.gebruikerRegistreren(event);
    }

    public void switchToLogin(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("hello-view.fxml"));
        root = loader.load();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }
}
