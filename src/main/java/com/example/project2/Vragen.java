package com.example.project2;
import java.sql.SQLOutput;
import java.util.Scanner;

public class Vragen {
    Scanner scanner = new Scanner(System.in);

    private String vraag;

    private ISendMessage aiComponent;

    public Vragen(ISendMessage aiComponent) {
        this.aiComponent = aiComponent;
        this.scanner = new Scanner(System.in);
    }

/*
    public void vragenStellen() {

        System.out.println("Nederlands of engels?");
        String Taal = scanner.nextLine();

        while (true) {
            System.out.println("Stel uw vraag: ");
            vraag = scanner.nextLine();


            if (Taal.equalsIgnoreCase("nederlands")) {
                String NlAntwoord = aiComponent.getAntwoordNederlands();
                System.out.println("Antwoord: " + NlAntwoord);
            } else {
                String EnAntwoord = aiComponent.getAntwoordEngels();
                System.out.println("Antwoord: " + EnAntwoord);
            }
        }
   }
 */
}