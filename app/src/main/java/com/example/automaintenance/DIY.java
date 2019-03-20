package com.example.automaintenance;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import com.google.gson.Gson;

public class DIY extends AppCompatActivity {
    String searchterm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diy);
        Intent intent = getIntent();
        // this will be where we get the info for the vehicle from
        //from shared preferences.
      //  Gson gson = new Gson();
    }
    // Vehicle Variable
    //private Vehicle vehicle;

    // Non-default Constructor
//    public DIY(Vehicle vehicle) {
//        this.vehicle = vehicle;
//    }

    // Class methods
    private String getVideoLink() {

        EditText searchbar = findViewById(R.id.search);
        String search = searchbar.getText().toString();
        return search;

    }

    /**
     * creates an intent to youtube to search for DIY Videos
     * @param view
     */
    public void toYoutube(View view){
        String search = getVideoLink();
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.youtube.com/results?search_query=" +  search)));
    }
}

