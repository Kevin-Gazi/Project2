package com.example.project2;

import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.ArrayList;

public class RegistratieController  {
    public ArrayList <Gebruiker> gebruikers;
    @FXML
    private TextField gebruikersnaamRegistratie;
    @FXML
    private PasswordField wachtwoordRegistratie;
    @FXML
    private TextField emailRegistratie;
    @FXML
    private Button registratieButton;

    public RegistratieController(){
        this.gebruikers = new ArrayList<>();
    }
    public void gebruikerRegistreren(){
        String gebruikersnaam = gebruikersnaamRegistratie.getText();
        String wachtwoord = wachtwoordRegistratie.getText();
        String email = emailRegistratie.getText();

        if (gebruikersnaam.isEmpty() || wachtwoord.isEmpty() || email.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Vul alle velden in.");
            alert.show();
            return;
        }
        Gebruiker gebruiker = new Gebruiker(gebruikersnaam,wachtwoord,email);
        voegGebruikerToe(gebruiker);
    }
    public void voegGebruikerToe(Gebruiker gebruiker){
        gebruikers.add(gebruiker);
    }




}