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

        String vehicleName = getVehicleName(vehicle);

        // Code to retrieve link for vehicle here.

        return videoLink;
    }

    // This function builds a vehicle string that can be used to find
    // DIY videos on YouTube.
    public String getVehicleName(Vehicle vehicle) {
        String vehicleName;

        String vehicleYear = vehicle.getYear();
        String vehicleMake = vehicle.getMake();
        String vehicleModel = vehicle.getModel();
        vehicleName = vehicleYear + " " + vehicleMake + " " + vehicleModel;
        System.out.println("The vehicle is " + vehicleName + ".");
        // Correct format i.e. "2019 Ford 150"

        return vehicleName;
    }
}
