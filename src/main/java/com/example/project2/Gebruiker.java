package com.example.project2;

import java.io.File;
import java.io.IOException;

public class Gebruiker {
    private String gebruikersnaam;
    private String wachtwoord;
    private String email;
    private String standaardTaal;


    public String getWachtwoord() {
        return wachtwoord;
    }
    public String getGebruikersnaam() {
        return gebruikersnaam;
    }
    public String getEmail() {
        return email;
    }
    public void setGebruikersnaam(String gebruikersnaam) {
        this.gebruikersnaam = gebruikersnaam;
    }

    public void setStandaardTaal(String standaardTaal) {
        this.standaardTaal = standaardTaal;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public void setWachtwoord(String wachtwoord) {
        this.wachtwoord = wachtwoord;
    }
    public Gebruiker(String gebruikersnaam, String wachtwoord, String email, String standaardtaal) {
        this.gebruikersnaam = gebruikersnaam;
        this.wachtwoord = wachtwoord;
        this.email = email;
        this.standaardTaal = standaardtaal;
    }
}