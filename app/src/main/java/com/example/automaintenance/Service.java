package com.example.automaintenance;

// The Service class is responsible for calculating
// all of the service dates according to the vehicle's
// mileage.

public class Service {
    private int dateOfNextService;

    // Class Methods
    public int getDateOfNextService() {
        return dateOfNextService;
    }

    public void setDateOfNextService(int dateOfNextService) {
        this.dateOfNextService = dateOfNextService;
    }

    public Service() {
        dateOfNextService = 0;
    }
    public int calculateNextService(int currentMiles) {
        return 0;
    }
}
