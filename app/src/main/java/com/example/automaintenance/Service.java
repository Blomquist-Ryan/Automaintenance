package com.example.automaintenance;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

// The Service class is responsible for calculating
// all of the service dates according to the vehicle's
// mileage.
public class Service extends AppCompatActivity {
    private Spinner Choices;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);
        Intent intent = getIntent();

        Choices = (Spinner) findViewById(R.id.serviceChoices);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.Service_Options));
        Choices.setAdapter(adapter);
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
