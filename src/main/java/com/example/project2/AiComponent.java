package com.example.project2;

import java.util.Random;

public class AiComponent implements ISendMessage, Observer {

    private String[] AntwoordenNederlands = {
            "We zijn momenteel offline.",
            "Sorry, ik kan nu niet antwoorden.",
            "De service is momenteel niet beschikbaar.",
            "We zijn momenteel bezig met onderhoud.",
            "Ik ben momenteel niet bereikbaar."
    };

    private String[] AntwoordenEngels = {
            "We are currently offline.",
            "Sorry, I can't respond right now.",
            "The service is currently unavailable.",
            "We are currently undergoing maintenance.",
            "I am currently not reachable."
    };

    private Random random;
    private String antwoordNederlands;
    private String antwoordEngels;


    public AiComponent() {
        this.random = new Random();
        generateAntwoordNederlands();
        generateAntwoordEngels();
    }

    private void generateAntwoordNederlands() {
        int index = random.nextInt(AntwoordenNederlands.length);
        antwoordNederlands = AntwoordenNederlands[index];
    }

    private void generateAntwoordEngels() {
        int index = random.nextInt(AntwoordenEngels.length);
        antwoordEngels = AntwoordenEngels[index];
    }

    @Override
    public String getAntwoordNederlands() {
        return antwoordNederlands;
    }

    @Override
    public String getAntwoordEngels() {
        return antwoordEngels;
    }

    @Override
    public void update(long responseTime) {
        // Add or subtract a random value to the response time
        long modifiedResponseTime = responseTime + random.nextInt(1000); // Random value between -500 and 500 milliseconds

        System.out.println("Response time: " + modifiedResponseTime + " ms");
    }
}
