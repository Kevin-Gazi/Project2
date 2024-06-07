package com.example.project2;

import java.util.ArrayList;
import java.util.List;

public abstract class ResponseManager {
    protected List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    protected void notifyObservers(long responseTime) {
        for (Observer observer : observers) {
            observer.update(responseTime);
        }
    }
}
