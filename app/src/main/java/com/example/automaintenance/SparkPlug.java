package com.example.automaintenance;

public class SparkPlug extends Service {
    @Override
    public int calculateNextService(int currentMiles) {
        return currentMiles + 30000;
    }
}
