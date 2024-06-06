package com.example.project2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Instellingen implements Initializable {

    @FXML
    private Label myLabel;
    @FXML
    private ChoiceBox<String> myChoiceBox;
    private String[] taal = {"Dutch/Nederlands", "English/Engels"};
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

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        myChoiceBox.getItems().addAll(taal);
        myChoiceBox.setOnAction(this::getTaal);
    }

    private void getTaal(ActionEvent event) {
        String myTaal = myChoiceBox.getValue();
        myLabel.setText(myTaal);
    }

    public void setGebruiker2(Gebruiker gebruiker) {
        this.gebruiker = gebruiker;
    }

    public boolean updateGebruikersnaam() {
        System.out.println(gebruiker.getGebruikersnaam());
        if (gebruiker != null) {
            gebruiker.setGebruikersnaam(gebruikersnaamRegistratie.getText());
            System.out.println(gebruiker.getGebruikersnaam());
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

    public boolean updateStandaardTaal() {
        if (gebruiker != null) {
            gebruiker.setStandaardtaal(myChoiceBox.getValue());
        }
        return true;
    }

    public void opslaan(ActionEvent event) {
        if(updateGebruikersnaam() && updateGebruikerWachtwoord() && updateGebruikerEmail() && updateStandaardTaal()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Instellingen succesvol opgeslagen.");
            alert.show();
        }
    }

    public void switchScene(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ChatScherm.fxml"));
        root = loader.load();

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }
}
