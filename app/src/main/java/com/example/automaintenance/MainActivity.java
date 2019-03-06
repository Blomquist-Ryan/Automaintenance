package com.example.automaintenance;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import static junit.framework.Assert.assertEquals;

public class MainActivity extends AppCompatActivity {
    List<Vehicle> vehicleList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

            String message = "it works";
            TextView text = findViewById(R.id.textView);
            text.setText(message);
    }
    public void addToVehicleList(View view){
        Intent intent = new Intent(this, AddVehicle.class);
        startActivity(intent);
        vehicleList.add(new Vehicle());
    }

    public void toOptionsPage(View view){
        Intent intent = new Intent(this, AddVehicle.class);
        startActivity(intent);
    }

}
