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

public class Parts extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parts);
    }

    /**
     * This method gets the video link and the builds
     * a searchable string that includes the year, make,
     * and model of the user's vehicle.
     * @return
     */
    private String getPartsLink() {
        String vehicleName = getVehicleName();
        EditText searchBar = findViewById(R.id.ebay_search);
        String search = vehicleName + " " + searchBar.getText().toString();
        return search;
    }

    /**
     * Creates an intent to eBay to search for DIY Parts
     * using the string that was created in getPartsLink().
     *
     * @param view
     */
    public void toEbay(View view) {
        String search = getPartsLink();
        startActivity(new Intent(Intent.ACTION_VIEW,
                Uri.parse("https://www.ebay.com/sch/i.html?_from=R40&_trksid=p2380057.m570.l1313.TR11.TRC1.A0.H1.X"
                        + search+ ".TRS0&_nkw=" + search + "&_sacat=0")));
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
