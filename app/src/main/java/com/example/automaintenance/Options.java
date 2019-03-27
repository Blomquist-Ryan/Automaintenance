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

    /**
     *  sends the user to the service paged
     * @param view
     */
    public void toService(View view){
        Intent intent = new Intent(this, Service.class);
        startActivity(intent);
    }

    /**
     * sends the user to the service history page
     * @param view
     */
    public void toServiceHistory(View view){
        Intent intent = new Intent(this, ServiceHistory.class);
        startActivity(intent);
    }

    /**
     * sends the user to the DIY page
     * @param view
     */
    public void toDIY(View view){
        Intent intent = new Intent(this, DIY.class);
        startActivity(intent);
    }

    public void toParts(View view) {
        Intent intent = new Intent(this, Parts.class);
        startActivity(intent);
    }
}
