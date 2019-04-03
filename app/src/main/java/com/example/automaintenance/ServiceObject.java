package com.example.automaintenance;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class ServiceObject {
    private String type = "";
    private String miles = "";
    private String date = "";

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMiles() {
        return miles;
    }

    public void setMiles(String miles) {
        this.miles = miles;
    }

    public String getDate() {
        return date;
    }

    public void setDate() {
        this.date= new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(new Date());

    }

    public String getString(){
        return  type + " - Date: " + date +  " - Miles: " + miles;
    }


}
