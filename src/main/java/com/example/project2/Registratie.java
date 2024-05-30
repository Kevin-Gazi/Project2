package com.example.project2;

import javafx.event.ActionEvent;

public abstract class Registratie {

    public final void gebruikerRegistreren(ActionEvent event) {
        if (checkVelden() && checkGebruikersnaam() && checkWachtwoord()) {
            voegGebruikerToe(event);
        }
    }

    abstract boolean checkVelden();

    abstract boolean checkGebruikersnaam();

    //abstract boolean checkEmail();

    abstract boolean checkWachtwoord();

    abstract void voegGebruikerToe(ActionEvent event);
}