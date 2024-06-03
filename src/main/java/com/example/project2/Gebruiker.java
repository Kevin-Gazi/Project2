package com.example.project2;

public class Gebruiker {
    private String gebruikersnaam;
    private String wachtwoord;
    private String email;
    private String standaardtaal;

    public Gebruiker(String gebruikersnaam, String wachtwoord, String email, String standaardtaal) {
        this.gebruikersnaam = gebruikersnaam;
        this.wachtwoord = wachtwoord;
        this.email = email;
        this.standaardtaal = standaardtaal;
    }

    public String getGebruikersnaam() {
        return gebruikersnaam;
    }

    public String getWachtwoord() {
        return wachtwoord;
    }
}
