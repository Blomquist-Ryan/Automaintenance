package com.example.automaintenance;

public class Vehicle {
    public double getVehicleMiles() {
        return vehicleMiles;
    }

    public void setVehicleMiles(double vehicleMiles) {
        this.vehicleMiles = vehicleMiles;
    }

    private double vehicleMiles;

    public Vehicle(){
        setVehicleMiles(20000);
    }


}
