package com.example.automaintenance;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Vehicle vehicleList = new <ArrayList> Vehicle();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

            String message = "it works";
            TextView text = findViewById(R.id.textView);
            text.setText(message);


    }

}
