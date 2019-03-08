package com.example.automaintenance;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class DIY extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diy);
        Intent intent = getIntent();
    }
    // Vehicle Variable
    private Vehicle vehicle;

    // Non-default Constructor
    public DIY(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    // Class methods
    public String getVideoLink(Vehicle vehicle) {
        String videoLink = "";

        // Code to retrieve link for vehicle here.

        return videoLink;
    }

}
