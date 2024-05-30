package com.example.project2;

import java.io.File;
import java.io.IOException;

public class Gebruiker {
    private String gebruikersnaam;
    private String wachtwoord;
    private String email;
    //private final String AICHAT_BESTAND;


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
    public void setEmail(String email) {
        this.email = email;
    }
    public void setWachtwoord(String wachtwoord) {
        this.wachtwoord = wachtwoord;
    }
    public Gebruiker(String gebruikersnaam, String wachtwoord, String email) {
        this.gebruikersnaam = gebruikersnaam;
        this.wachtwoord = wachtwoord;
        this.email = email;
    }
}