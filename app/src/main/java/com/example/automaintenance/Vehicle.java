package com.example.automaintenance;

public class Vehicle {
    private int  vehicleMiles;


    public int getVehicleMiles() {
        return vehicleMiles;
    }

    public void setVehicleMiles(int vehicleMiles) {
        this.vehicleMiles = vehicleMiles;
    }



    public Vehicle(){
        setVehicleMiles(20000);
    }

    public void setNextOilChangeMiles(){
        vehicleMiles += 3000;
    }

    public void setNextTireRotationMiles(){
        vehicleMiles += 5000;
    }

}
