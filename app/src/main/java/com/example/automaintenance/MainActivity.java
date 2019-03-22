package com.example.automaintenance;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;

/**
 * Main Class.
 *
 * This class is the entry point for the app and
 * is in charge of a lot of things such as saving
 * and loading preferences, adding vehicles to
 * the app, and providing a landing for when the
 * user launches the app.
 */
public class MainActivity extends AppCompatActivity {
    List<Vehicle> vehicleList = new ArrayList<>();
    List<String> vehicles = new ArrayList<>();
    public String savedVehicle;
    private Spinner Choices;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        load();
        for (Vehicle car:vehicleList             ) {
            vehicles.add(car.getVehicleName(car));


        }

        Choices = (Spinner) findViewById(R.id.serviceChoices);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, vehicles);
        Choices.setAdapter(adapter);
    }

    /**
     * Sends the user to a new intent so that they
     * can add their own vehicles to the app.
     *
     * The user can add an unlimited amount of vehicles.
     * @param view
     */
    public void addToVehicleList(View view) {
        Intent intent = new Intent(this, NewVehicle.class);
        startActivity(intent);
    }

    /**
     * Sends the user to the options page. There they can
     * look at the Option for each vehicle.
     * @param view
     */
    public void toOptionsPage(View view) {
        Intent intent = new Intent(this, Options.class);
        startActivity(intent);
    }

    /**
     * Loads vehicles from the saved preferences and then
     * populates the list on the main activity with those
     * vehicles.
     */
    public void load() {
        Gson gson = new Gson();
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        String savedVehicleInfo = prefs.getString("newVehicle","Missing");

        if (savedVehicleInfo.equals("Missing")) {
            Log.i("Inside Load", "Couldn't load savedVehicleInfo.");
        }
        else {
            Vehicle loadedVehicle = gson.fromJson(savedVehicleInfo, Vehicle.class);
            vehicleList.add(loadedVehicle);
            Log.i("Inside Else:", "Added saved vehicle.");
        }
    }
}