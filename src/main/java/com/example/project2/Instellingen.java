package com.example.project2;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Instellingen {
    private Gebruiker gebruiker;
    @FXML
    private TextField gebruikersnaamInstellingen;
    @FXML
    private TextField wachtwoordInstellingen;
    @FXML
    private TextField emailInstellingen;
    @FXML
    private TextField standaardtaalInstellingen;


    public void updateGebruikersnaam(){
        gebruiker.setGebruikersnaam(gebruikersnaamInstellingen.getText());
    }

    public void updateGebruikerWachtwoord(){
        gebruiker.setGebruikersnaam(wachtwoordInstellingen.getText());
    }

    public void updateGebruikerEmail(){
        gebruiker.setGebruikersnaam(emailInstellingen.getText());
    }

    public void updateStandaardTaal(){
        gebruiker.setStandaardTaal(standaardtaalInstellingen.getText());
    }
}
