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
    private Gebruiker gebruiker;
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

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        myChoiceBox.getItems().addAll(taal);
        myChoiceBox.setOnAction(this::getTaal);
    }

    private void getTaal(ActionEvent event) {
        String myTaal = myChoiceBox.getValue();
        myLabel.setText(myTaal);
    }

    public void setGebruiker(Gebruiker gebruiker) {
        this.gebruiker = gebruiker;
        updateFields();
    }

    private void updateFields() {
        gebruikersnaamRegistratie.setText(gebruiker.getGebruikersnaam());
        emailRegistratie.setText(gebruiker.getEmail());
        myChoiceBox.setValue(gebruiker.getStandaardtaal());
    }

    public void updateGebruikersnaam() {
        gebruiker.setGebruikersnaam(gebruikersnaamRegistratie.getText());
    }

    public void updateGebruikerWachtwoord() {
        // Je zou hier logica kunnen toevoegen om te controleren of het huidige wachtwoord correct is
        if (wachtwoordRegistratie.getText().equals(wachtwoord2Registratie.getText())) {
            gebruiker.setWachtwoord(wachtwoordRegistratie.getText());
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Wachtwoorden komen niet overeen.");
            alert.show();
        }
    }

    public void updateGebruikerEmail() {
        gebruiker.setEmail(emailRegistratie.getText());
    }

    public void updateStandaardTaal() {
        gebruiker.setStandaardtaal(myChoiceBox.getValue());
    }

    public void opslaan(ActionEvent event) {
        updateGebruikersnaam();
        updateGebruikerWachtwoord();
        updateGebruikerEmail();
        updateStandaardTaal();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("Instellingen succesvol opgeslagen.");
        alert.show();
    }

    public void switchScene(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ChatScherm.fxml"));
        root = loader.load();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }
}
