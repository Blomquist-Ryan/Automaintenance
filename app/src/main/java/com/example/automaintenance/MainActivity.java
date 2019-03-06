package com.example.automaintenance;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import static junit.framework.Assert.assertEquals;

public class MainActivity extends AppCompatActivity {
    List<Vehicle> vehicleList = new ArrayList<>();
    String savedVehicle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        load();

        save();
    }

    public void addToVehicleList(View view){
        Intent intent = new Intent(this, AddVehicle.class);
        startActivity(intent);

        AddVehicle vehicle = new AddVehicle();
        Vehicle newVehicle  = vehicle.newVehicle();

        vehicleList.add(newVehicle);
    }

    public void toOptionsPage(View view){
        Intent intent = new Intent(this, AddVehicle.class);
        startActivity(intent);
    }

    public void save() {
        Gson gson = new Gson();
        savedVehicle = gson.toJson(vehicleList);
        SharedPreferences mSettings = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = mSettings.edit();
        editor.putString(savedVehicle, "savedVehicle");
        editor.apply();
    }

    public void load() {
        Gson gson = new Gson();
        SharedPreferences mSettings = this.getSharedPreferences("name_preferences.xml", 0);
        String sharedprefs = mSettings.getString("missing","savedVehicle");
        vehicleList = gson.fromJson(sharedprefs, new TypeToken<List<Vehicle>>(){}.getType());
    }


}
