package com.example.automaintenance;

import java.util.List;

public class Vehicle {
    // Vehicle Variables:
    private String vehicleMiles;
    private String make;
    private String model;
    private String year;
    private String licensePlate;
    private String vin;

    /**
     * creates sa vehicle with default values of blank values
     */
    public Vehicle() {
        setMake("");
        setModel("");
        setVehicleMiles("");
        setYear("");
        setLicensePlate("");
        setVin("");
    }


    public String getVehicleMiles() {
        return vehicleMiles;
    }

    public void setVehicleMiles(String vehicleMiles) {
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

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
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





    /**
     *  builds a vehicle string that can be used to find
     * vDIY videos on YouTube.
     * @param vehicle the desired vehicle to get the information of
     * @return a string containing the direct information about the vehicle (ie year, make, model)
     */
    public String getVehicleName(Vehicle vehicle) {
        String vehicleName;

        String vehicleYear = vehicle.getYear();
        String vehicleMake = vehicle.getMake();
        String vehicleModel = vehicle.getModel();
        vehicleName = vehicleYear + " " + vehicleMake + " " + vehicleModel;
        System.out.println("The vehicle is " + vehicleName + ".");
        // Correct format i.e. "2019 Ford 150"

        return vehicleName;
    }

    public void getVehicleNameinList(List<Vehicle> vehicleList) {

    }

}
