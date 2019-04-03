package com.example.automaintenance;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

public class ServiceHistory extends AppCompatActivity {
    private Spinner Choices;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_history);
        Intent intent = getIntent();

        Choices = findViewById(R.id.serviceType);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.Service_Options));
        Choices.setAdapter(adapter);

        TextView oilChange = findViewById(R.id.History);
        TextView rotation = findViewById(R.id.tires);
        TextView battery = findViewById(R.id.battery);
        TextView headlights = findViewById(R.id.headlights);
        TextView sparks = findViewById(R.id.sparks);
        TextView air = findViewById(R.id.air);
        TextView O2 = findViewById(R.id.O2);

        oilChange.setText(load("Oil Change"));
        rotation.setText(load("Tire Rotation"));
        battery.setText(load("Battery"));
        headlights.setText(load("Headlights"));
        sparks.setText(load("Spark Plugs"));
        air.setText(load("Air Filter"));
        O2.setText(load("O2 Sensors"));

    }


    public String load(String type){
        Gson gson = new Gson();
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        String savedhistoryInfo = prefs.getString(type, "Missing");

        if (savedhistoryInfo.equals("Missing")) {
            Log.i("Inside Load", "Couldn't load savedVehicleInfo.");
            return null;
        }
        else {

            ServiceObject loadedService = gson.fromJson(savedhistoryInfo, ServiceObject.class);
            String history = loadedService.getString();
            Log.i("Inside Else:", "Added saved vehicle.");
            return history;
        }

}
}
