package com.example.automaintenance;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

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

        newVehicle.setMake("Ford");
        newVehicle.setModel("Focus");
        newVehicle.setYear(2015);
        newVehicle.setVehicleMiles(100000);
        newVehicle.setLicensePlate("Wd4956");
        newVehicle.setVin("yn4865nfiei3nf");

        Gson gson = new Gson();
        vehicle = gson.toJson(vehicle);
        SharedPreferences mSettings = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = mSettings.edit();
        editor.putString(vehicle, "newVehicle");
        editor.apply();
    }
}
