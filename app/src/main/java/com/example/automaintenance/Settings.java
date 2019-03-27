package com.example.automaintenance;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Settings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
    }

    /**
     * This function clears the user's saved vehicle
     * and then navigates back to the home screen.
     * @param view
     */
    public void clearVehicle(View view) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        prefs.edit().clear().apply();

        Toast.makeText(this, "The user's saved vehicle has been cleared.",
                Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    public void rickRoll(View view) {
        startActivity(new Intent(Intent.ACTION_VIEW,
                Uri.parse("http://www.youtube.com/watch?v=dQw4w9WgXcQ")));
    }
}