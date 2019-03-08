package com.example.automaintenance;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

// The Service class is responsible for calculating
// all of the service dates according to the vehicle's
// mileage.
public class Service extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);
        Intent intent = getIntent();
    }

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
