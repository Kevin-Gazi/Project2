package com.example.project2;
import java.util.Scanner;


public class Gesprek {
    private int gesprekID;
    private String onderwerp;
    private Gebruiker gebruiker;
    private AiComponent aiComponent;
    Scanner scanner = new Scanner(System.in);

    public void nieuweGesprek(){
        System.out.println("Wat is het onderwerp van het gesprek?");
        onderwerp = scanner.nextLine();
        System.out.println("Gesprek gestart met onderwerp: " + onderwerp);
        Vragen vragen = new Vragen(aiComponent);
        vragen.vragenStellen();
    }

}