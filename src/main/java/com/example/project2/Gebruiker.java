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
        //this.AICHAT_BESTAND = gebruikersnaam + "_AICHAT.csv";
        //initBudgetBestand();
    }
    /*private void initBudgetBestand() {
        File budgetBestand = new File(this.AICHAT_BESTAND);
        if (!budgetBestand.exists()) {
            try {
                budgetBestand.createNewFile();
            } catch (IOException var3) {
                String var10001 = this.gebruikersnaam;
                System.out.println("Fout bij het aanmaken van het budgetbestand voor gebruiker " + var10001 + ": " + var3.getMessage());
            }
        }
    }     */
}