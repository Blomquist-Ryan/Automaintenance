package com.example.automaintenance;

public class AirFilter extends Service {
    @Override
    public int calculateNextService(int currentMiles) {
        return currentMiles + (12000 * 3);
    }
}
