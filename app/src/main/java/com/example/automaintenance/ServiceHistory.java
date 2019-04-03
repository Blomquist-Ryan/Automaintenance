package com.example.automaintenance;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Spinner;
import android.widget.TextView;
import com.google.gson.Gson;


public class ServiceHistory extends AppCompatActivity {
    private Spinner Choices;

    /**
     * This function is in charge of showing the user
     * the last known date of service for each serviceable
     * item in the user's vehicle.
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_history);
        Intent intent = getIntent();

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

    /**
     * This function loads the saved service records.
     * @param type
     * @return
     */
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
