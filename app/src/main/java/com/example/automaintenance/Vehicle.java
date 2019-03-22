package com.example.automaintenance;

public class Vehicle {
    // Vehicle Variables:
    private String vehicleMiles;
    private String make;
    private String model;
    private String year;
    private String licensePlate;
    private String vin;

    /**
     * Creates sa vehicle with default values of blank values
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
     *  Builds a vehicle string that can be used to find
     *  DIY videos on YouTube.
     * @return a string containing the direct information about the vehicle (ie year, make, model)
     */
    public String getVehicleName() {
        String vehicleYear = getYear();
        String vehicleMake = getMake();
        String vehicleModel = getModel();
        String vehicleName = vehicleYear + " " + vehicleMake + " " + vehicleModel;
        return vehicleName;
    }
}
