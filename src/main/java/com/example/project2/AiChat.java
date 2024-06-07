package com.example.project2;

import java.util.Random;

public class AiChat implements Observer {
    AiComponent antwoorden;
    private Random random = new Random();

    public AiComponent geefAntwoord() {
        return antwoorden;
    }

    @Override
    public void update(long responseTime) {
        // Add or subtract a random value to the response time
        long modifiedResponseTime = responseTime + random.nextInt(1000); // Random value between -500 and 500 milliseconds

        System.out.println("Response time: " + modifiedResponseTime + " ms");
    }
}