package com.example.automaintenance;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

import com.google.gson.Gson;

public class AddVehicle extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_vehicle);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Intent intent = getIntent();
        newVehicle();
    }

    public void returnToHomePage(View view){
        Intent intent = new Intent(this, AddVehicle.class);
        startActivity(intent);
    }

    public void newVehicle() {
        Vehicle newVehicle = new Vehicle();
        String vehicle = "";

        EditText make = findViewById(R.id.newMake);
        String newMake = make.toString();

        EditText model = findViewById(R.id.newModel);
        String newModel = model.toString();

        EditText year = findViewById(R.id.newYear);
        String newYear = year.toString();

        EditText miles = findViewById(R.id.newMiles);
        String newMiles = miles.toString();

        EditText license = findViewById(R.id.newLicense);
        String newLicense = license.toString();

        EditText vin = findViewById(R.id.newVin);
        String newVin = vin.toString();





        newVehicle.setMake(newMake);
        newVehicle.setModel(newModel);
        newVehicle.setYear(newYear);
        newVehicle.setVehicleMiles(newMiles);
        newVehicle.setLicensePlate(newLicense);
        newVehicle.setVin(newVin);

        Gson gson = new Gson();
        vehicle = gson.toJson(vehicle);
        SharedPreferences mSettings = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = mSettings.edit();
        editor.putString(vehicle, "newVehicle");
        editor.apply();
    }
}