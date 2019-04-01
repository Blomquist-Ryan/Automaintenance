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

        TextView history = findViewById(R.id.History);
//        //List<Service> services = new ArrayList<>();
        Service service = load();
          //service = load();
        history.setText(service.toString());


    }



    public Service load(){Gson gson = new Gson();
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        String savedhistoryInfo = prefs.getString("serviceHistory", "Missing");

        if (savedhistoryInfo.equals("Missing")) {
            Log.i("Inside Load", "Couldn't load savedVehicleInfo.");
            return null;
        }
        else {
//            List<Service> history = gson.fromJson(savedhistoryInfo, new TypeToken<List<Service>>() {
////            }.getType());
            Service history = new Service();
            Log.i("Inside Else:", "Added saved vehicle.");
            return history;
        }

}
}
