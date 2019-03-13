package com.example.automaintenance;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;

public class NewVehicle extends AppCompatActivity {
    public boolean flag;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_vehicle);
    }

    public void returnToHomePage(View view) {
        newVehicle();
        String vehicle = "";

        if (flag) {
            Gson gson = new Gson();
            vehicle = gson.toJson(vehicle);

            System.out.println("!!!!!!!!!" + vehicle);

            SharedPreferences mSettings = PreferenceManager.getDefaultSharedPreferences(this);
            SharedPreferences.Editor editor = mSettings.edit();
            editor.putString(vehicle, "newVehicle");
            editor.apply();

            System.out.println("!!!!!!!!!" + vehicle);

            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
    }

    public void newVehicle() {
        flag = false;
        Vehicle newVehicle = new Vehicle();

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

        if (TextUtils.isEmpty(make.getText().toString()))
        {
            Toast.makeText(this, "Please fill in required fields.", Toast.LENGTH_SHORT).show();
        }
        else if (TextUtils.isEmpty(model.getText().toString()))
        {
            Toast.makeText(this, "Please fill in required fields.", Toast.LENGTH_SHORT).show();
        }
        else if (TextUtils.isEmpty(year.getText().toString()))
        {
            Toast.makeText(this, "Please fill in required fields.", Toast.LENGTH_SHORT).show();
        }
        else if (TextUtils.isEmpty(miles.getText().toString()))
        {
            Toast.makeText(this, "Please fill in required fields.", Toast.LENGTH_SHORT).show();
        }
        else {
            flag = true;
        }
    }
}