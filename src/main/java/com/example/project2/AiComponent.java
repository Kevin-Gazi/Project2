package com.example.project2;

import java.util.Random;

public class AiComponent implements ISendMessage{

    private String[] Antwoorden = {
            "We zijn momenteel offline.",
            "Sorry, ik kan nu niet antwoorden.",
            "De service is momenteel niet beschikbaar.",
            "We zijn momenteel bezig met onderhoud.",
            "Ik ben momenteel niet bereikbaar."
    };

    private Random random;

    public AiComponent() {
        this.random = new Random();
    }

    public String getAntwoord() {
        int index = random.nextInt(Antwoorden.length);
        return Antwoorden[index];
    }
}
