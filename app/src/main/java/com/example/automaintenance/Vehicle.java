package com.example.automaintenance;

public class Vehicle {
    // Vehicle Variables:
    private int vehicleMiles;
    private String make;
    private String model;
    private int year;
    private String licensePlate;
    private String vin;


    public int getVehicleMiles() {
        return vehicleMiles;
    }

    public void setVehicleMiles(int vehicleMiles) {
        this.vehicleMiles = vehicleMiles;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }
}
