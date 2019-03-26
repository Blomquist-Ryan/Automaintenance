package com.example.automaintenance;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import com.google.gson.Gson;

public class DIY extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diy);
        Intent intent = getIntent();
    }
    // Class methods

    /**
     * This method gets the video link and the builds
     * a searchable string that includes the year, make,
     * and model of the user's vehicle.
     * @return
     */
    private String getVideoLink() {
        String vehicleName = getVehicleName();
        EditText searchBar = findViewById(R.id.search);
        String search = vehicleName + " " + searchBar.getText().toString();
        return search;
    }

    /**
     * Creates an intent to youtube to search for DIY Videos
     * using the string that was created in getVideoLink().
     *
     * @param view
     */
    public void toYoutube(View view) {
        String search = getVideoLink();
        startActivity(new Intent(Intent.ACTION_VIEW,
                Uri.parse("http://www.youtube.com/results?search_query=" + search)));
    }

    /**
     * Loads the user's vehicle from sharedPreferences and then
     * calls the getVehicleName function in order to return the vehicle's
     * name for the YouTube search.
     * @return vehicleName
     */
    public String getVehicleName() {
        Gson gson = new Gson();
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        String savedVehicleInfo = prefs.getString("newVehicle", "Missing");

        if (savedVehicleInfo.equals("Missing")) {
            return null;
        }
        else {
            Vehicle loadedVehicle = gson.fromJson(savedVehicleInfo, Vehicle.class);
            String vehicleName = loadedVehicle.getVehicleName();
            return vehicleName;
        }
    }
}

