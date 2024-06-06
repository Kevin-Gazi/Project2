package com.example.project2;

import javafx.event.ActionEvent;

public abstract class Registratie {

    public final void gebruikerRegistreren(ActionEvent event) {
        if (checkVelden() && checkGebruikersnaam() && checkWachtwoord() && checkStandaardTaal()) {
            voegGebruikerToe(event);
        }
    }
    abstract boolean checkVelden();
    abstract boolean checkGebruikersnaam();
    abstract boolean checkWachtwoord();
    abstract boolean checkStandaardTaal();
    abstract void voegGebruikerToe(ActionEvent event);
}
