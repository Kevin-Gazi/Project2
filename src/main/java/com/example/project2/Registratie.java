package com.example.project2;

abstract class Registratie {

    public final void gebruikerRegistreren() {
        checkVelden();
        checkGebruikersnaam();
        checkWachtwoord();
        maakGebruikerAan();
        voegGebruikerToe();
    }

    abstract boolean checkVelden();

    abstract boolean checkGebruikersnaam();

    abstract boolean checkWachtwoord();

    abstract void maakGebruikerAan();

    abstract void voegGebruikerToe();
}

