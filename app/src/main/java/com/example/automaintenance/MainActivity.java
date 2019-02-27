package com.example.automaintenance;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
    public void addToVehicleList(){
        vehicleList.add(new Vehicle());
    }

}
