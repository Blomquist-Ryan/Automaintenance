package com.example.automaintenance;

public class O2Sensors extends Service {
    @Override
    public int calculateNextService(int currentMiles) {
        return currentMiles + 100000;
    }
}
