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

    public void setGebruikersnaam(String gebruikersnaam) {
        this.gebruikersnaam = gebruikersnaam;
    }

    public void setWachtwoord(String wachtwoord) {
        this.wachtwoord = wachtwoord;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setStandaardtaal(String standaardtaal) {
        this.standaardtaal = standaardtaal;
    }

    public String getEmail() {
        return email;
    }

    public String getStandaardtaal() {
        return standaardtaal;
    }
}
