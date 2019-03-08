package com.example.automaintenance;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class AddVehicle extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_vehicle);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Intent intent = getIntent();
    }

    public void returnToHomePage(View view){
        Intent intent = new Intent(this, AddVehicle.class);
        startActivity(intent);

    }

    public Vehicle newVehicle() {
        Vehicle newVehicle = new Vehicle();

        newVehicle.setMake();
        newVehicle.setModel();
        newVehicle.setYear();
        newVehicle.setVehicleMiles();
        newVehicle.setLicensePlate();
        newVehicle.setVin();

        return newVehicle;
    }

}
