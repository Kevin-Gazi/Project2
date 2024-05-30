package com.example.project2;
import java.util.Scanner;


public class Vragen {
    Scanner scanner = new Scanner(System.in);

    private String vraag;

    private ISendMessage aiComponent;

    public Vragen(ISendMessage aiComponent) {
        this.aiComponent = aiComponent;
        this.scanner = new Scanner(System.in);
    }

    public void vragenStellen() {
        // System.out.println("Wat is uw onderwerp?");
        String onderwerp = scanner.nextLine();

        while (true) {
            // System.out.println Stel uw vraag:");
            vraag = scanner.nextLine();

            String antwoord = aiComponent.getAntwoord();
            System.out.println("Antwoord: " + antwoord);
        }
    }

}