package com.example.automaintenance;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "In onCreate";
    List<Vehicle> vehicleList = new ArrayList<>();
    public String savedVehicle = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        load();
        Log.i(TAG, "onCreate: Loaded vehicle from savedPrefences " + savedVehicle + ".");
    }

    public void addToVehicleList(View view){
        Intent intent = new Intent(this, NewVehicle.class);
        startActivity(intent);
    }

    public void toOptionsPage(View view) {
        Intent intent = new Intent(this, Options.class);
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
        String savedVehicleInfo = mSettings.getString("vehicle","Missing");

        if (savedVehicleInfo.equals("Missing")) {
            Log.i("Inside Load", "Couldn't load savedVehicleInfo.");
        }
        else {
            vehicleList = gson.fromJson(savedVehicleInfo, new TypeToken<List<Vehicle>>() {
            }.getType());
        }
    }
}
