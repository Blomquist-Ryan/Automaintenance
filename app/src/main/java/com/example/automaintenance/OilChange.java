package com.example.automaintenance;

public class OilChange extends Service {
    @Override
    public int calculateNextService(int currentMiles) {
        return currentMiles + 4000;
    }
}
