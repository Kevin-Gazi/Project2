package com.example.project2;
import java.util.Scanner;


public class Vragen implements ISendMessage {
    Scanner scanner = new Scanner(System.in);

    private String vragen;

    public void vragenStellen() {
        // System.out.println("Wat is uw onderwerp?");
        String onderwerp = scanner.nextLine();

        while (true) {
            // System.out.println("Stel uw vraag (of typ 'stop' om te stoppen):");
            vragen = scanner.nextLine();

            if (vragen.equalsIgnoreCase("stop")) {
                break;
            }
        }
    }

}