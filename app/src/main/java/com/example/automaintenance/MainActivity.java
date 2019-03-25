package com.example.automaintenance;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.google.gson.Gson;

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
    public boolean flag;
    public Vehicle userVehicle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        flag = false;
        String nameOfVehicle = "";
        userVehicle = load(); // Attempt to load a vehicle.

        Button AddVehicle = findViewById(R.id.button); //Create a button for addVehicle
        Button optionsButton = findViewById(R.id.options); //Create a button for Options

        if (flag) { // if (no vehicle found in savedPreferences)
            AddVehicle.setVisibility(View.VISIBLE); //SHOW the button
            optionsButton.setEnabled(false);
        }
        else {
            nameOfVehicle = userVehicle.getVehicleName();
            optionsButton.setEnabled(true);
        }

        final TextView vehicleTextView = findViewById(R.id.textView6);
        vehicleTextView.setText(displayVehicle(nameOfVehicle));
    }

    /**
     * A function that determines what to display
     * in the vehicle text view box.
     * @param vehicle
     * @return
     */
    public String displayVehicle(String vehicle) {
        if (vehicle.equals("")) {
            return "Please add a Vehicle.";
        }
        else {
            return userVehicle.getVehicleName();
        }
    }

    /**
     * Sends the user to a new intent so that they
     * can add their own vehicles to the app.
     * <p>
     * The user can add an unlimited amount of vehicles.
     *
     * @param view
     */
    public void addToVehicleList(View view) {
        Intent intent = new Intent(this, NewVehicle.class);
        startActivity(intent);
    }

    /**
     * Starts the settings activity.
     * @param view
     */
    public void toSettings(View view) {
        Intent intent = new Intent(this, Settings.class);
        startActivity(intent);
    }

    /**
     * Sends the user to the options page. There they can
     * look at the Option for each vehicle.
     *
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
    public Vehicle load() {
        Gson gson = new Gson();
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        String savedVehicleInfo = prefs.getString("newVehicle", "Missing");

        if (savedVehicleInfo.equals("Missing")) {
            Log.i("Inside Load", "Couldn't load savedVehicleInfo.");
            flag = true;
            return null;
        }
        else {
            Vehicle loadedVehicle = gson.fromJson(savedVehicleInfo, Vehicle.class);
            Log.i("Inside Else:", "Added saved vehicle.");
            return loadedVehicle;
        }
    }
}