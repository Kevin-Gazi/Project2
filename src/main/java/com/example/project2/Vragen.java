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
        while (true) {
            // System.out.println Stel uw vraag:");
            vraag = scanner.nextLine();
            /*
            if (Taal.equalsIgnoreCase("Nederlands")) {
                String NlAntwoord = aiComponent.getAntwoordNederlands();
                System.out.println("Antwoord: " + NlAntwoord);
            } else {
                String EnAntwoord = aiComponent.getAntwoordEngels();
                System.out.println("Antwoord: " + EnAntwoord);
            }

             */
        }
    }

}