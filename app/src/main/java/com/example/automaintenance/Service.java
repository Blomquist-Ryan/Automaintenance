package com.example.automaintenance;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

// The Service class is responsible for calculating
// all of the service dates according to the vehicle's
// mileage.

/*
        create new objects of each service type and save them to shared preferences
        try and get shared preferences to display in service History
 */



public class Service extends AppCompatActivity {
    private Spinner Choices;
    //String type = "";

    public String getMiles() {
        return miles;
    }

    String miles = "";
    //String date = "";



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
//
//    private int dateOfNextService;
//
//    // Class Methods
//    public int getDateOfNextService() {
//        return dateOfNextService;
//    }
//
//    public void setDateOfNextService(int dateOfNextService) {
//        this.dateOfNextService = dateOfNextService;
//    }
//
//    public Service() {
//        dateOfNextService = 0;
//    }
//
    public int calculateNextService(int currentMiles) {
        return 0;
    }
//
   public void saveData(View view){


        Service service = new Service();


       EditText make = findViewById(R.id.servicemiles);
       String newMiles = make.getText().toString();
       service.miles = newMiles;
       Log.i("Inside saveData", "saveData: " + service.getMiles());

       Gson gson = new Gson();
       String history = gson.toJson(service);

       SharedPreferences histpref = PreferenceManager.getDefaultSharedPreferences(this);
       SharedPreferences.Editor editor = histpref.edit();
       editor.putString("savedHistory", history);
       editor.apply();

//       // List<Service> service = new ArrayList<>();
//        Service service = new Service();
////        Spinner spinner = findViewById(R.id.serviceChoices);
////        String serviceOption = spinner.getSelectedItem().toString();
////        service.type = serviceOption;
//       // service = load();
//
//
//
////        ;
////
////
////
//
    }


}
