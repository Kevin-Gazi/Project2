package com.example.project2;

import java.util.ArrayList;

public class GebruikerModel {
    private ArrayList<Gebruiker> gebruikers;

    public GebruikerModel() {
        this.gebruikers = new ArrayList<>();
    }

    public ArrayList<Gebruiker> getGebruikers() {
        return gebruikers;
    }

    public void voegGebruikerToe(Gebruiker gebruiker) {
        gebruikers.add(gebruiker);
    }
}
