package com.example.automaintenance;

public class Tires extends Service {
    @Override
    public int calculateNextService(int currentMiles) {
        return currentMiles + 6000;
    }
}
