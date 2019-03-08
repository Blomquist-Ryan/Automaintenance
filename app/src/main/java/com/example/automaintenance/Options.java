package com.example.automaintenance;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Options extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);
        Intent intent = getIntent();

    }

    public void toService(View view){
        Intent intent = new Intent(this, AddVehicle.class);
        startActivity(intent);

    }

    public void toServiceHistory(View view){
        Intent intent = new Intent(this, AddVehicle.class);
        startActivity(intent);

    }

    public void toDIY(View view){
        Intent intent = new Intent(this, AddVehicle.class);
        startActivity(intent);

    }
}
