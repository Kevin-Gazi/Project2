package com.example.project2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class Instellingen {

    @FXML
    private TextField gebruikersnaamRegistratie;
    @FXML
    private TextField wachtwoordRegistratie;
    @FXML
    private TextField wachtwoord2Registratie;
    @FXML
    private TextField emailRegistratie;
    @FXML
    private Button opslaanButton;
    @FXML
    private Button terugButton;
    private Stage stage;
    private Parent root;
    private Gebruiker gebruiker;

    public void setGebruiker2(Gebruiker gebruiker) {
        this.gebruiker = gebruiker;
        if (gebruiker != null) {
            gebruikersnaamRegistratie.setText(gebruiker.getGebruikersnaam());
            emailRegistratie.setText(gebruiker.getEmail());
        }
    }

    public boolean updateGebruikersnaam() {
        if (gebruiker != null) {
            gebruiker.setGebruikersnaam(gebruikersnaamRegistratie.getText());
        }
        return true;
    }

    public boolean updateGebruikerWachtwoord() {
        boolean a = false;
        String wachtwoord = wachtwoordRegistratie.getText();
        String wachtwoord2 = wachtwoord2Registratie.getText();

        if (wachtwoord.length() < 6) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Wachtwoord moet minimaal 6 karakters lang zijn.");
            alert.show();
        } else if (!wachtwoord.equals(wachtwoord2)) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Wachtwoorden komen niet overeen.");
            alert.show();
        } else {
            if (gebruiker != null) {
                gebruiker.setWachtwoord(wachtwoord);
                a = true;
            }
        }
        return a;
    }

    public boolean updateGebruikerEmail() {
        if (gebruiker != null) {
            gebruiker.setEmail(emailRegistratie.getText());
        }
        return true;
    }

    public void opslaan(ActionEvent event) {
        if (updateGebruikersnaam() && updateGebruikerWachtwoord() && updateGebruikerEmail()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Instellingen succesvol opgeslagen.");
            alert.show();
        }
    }

    public void switchScene(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ChatScherm.fxml"));
        root = loader.load();

        ChatSchermController chatController = loader.getController();
        chatController.setGebruiker(this.gebruiker);

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }
}
