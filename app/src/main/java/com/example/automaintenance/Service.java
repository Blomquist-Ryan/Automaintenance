package com.example.automaintenance;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import com.google.gson.Gson;

/**
        create new objects of each service type and save them to shared preferences
        try and get shared preferences to display in service History
 */
public class Service extends AppCompatActivity {
    //Private member variables
    private Spinner Choices;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);
        Intent intent = getIntent();

        Choices = findViewById(R.id.serviceChoices);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.Service_Options));
        Choices.setAdapter(adapter);
    }

    /**
     * SaveData saves the service item to shardPreferences.
     * @param view
     */
    public void saveData(View view){
        ServiceObject service = new ServiceObject();

        EditText make = findViewById(R.id.servicemiles);
        service.setMiles(make.getText().toString());

        Spinner spinner = findViewById(R.id.serviceChoices);
        service.setType(spinner.getSelectedItem().toString());
        service.setDate();

        String prefLocation = "";


        if (service.getType().equals("Oil Change")) {
            prefLocation = "Oil Change";
        }
        else if (service.getType().equals("Tire Rotation")) {
            prefLocation = "Tire Rotation";
        }
        else if (service.getType().equals("Battery")) {
            prefLocation = "Battery";
        }
        else if (service.getType().equals("Headlights")) {
            prefLocation = "Headlights";
        }
        else if (service.getType().equals("Spark Plugs")) {
            prefLocation = "Spark Plugs";
        }
        else if (service.getType().equals("Air Filter")) {
            prefLocation = "Air Filter";
        }
        else if (service.getType().equals("O2 Sensors")) {
            prefLocation = "O2 Sensors";
        }

        Gson gson = new Gson();
        String history = gson.toJson(service);

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(prefLocation, history);
        editor.apply();

        Intent intent = new Intent(this, Options.class);
        startActivity(intent);
    }
}
