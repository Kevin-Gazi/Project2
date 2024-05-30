package com.example.project2;

public abstract class Registratie {

    public final void gebruikerRegistreren() {
        if (checkVelden() && checkGebruikersnaam() && checkWachtwoord()) {
            voegGebruikerToe();
        }
    }

    abstract boolean checkVelden();

    abstract boolean checkGebruikersnaam();

    //abstract boolean checkEmail();

    abstract boolean checkWachtwoord();

    abstract void voegGebruikerToe();
}