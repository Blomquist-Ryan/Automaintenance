package com.example.automaintenance;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }
//
//    @Test
//    public  void addedToVehicleListPorperly(){
//        MainActivity vehicle = new MainActivity();
//        int expected = vehicle.vehicleList.size() + 1;
//        vehicle.addToVehicleList();
//        int actual = vehicle.vehicleList.size();
//                assertEquals(expected, actual);
//    }
//
//    @Test
//    public void setNextOilChangeMiles(){
//        Vehicle vehicle = new Vehicle();
//        int expected = 23000;
//        vehicle.setNextOilChangeMiles();
//        int actual = vehicle.getVehicleMiles();
//        assertEquals(expected, actual);
//    }
//
//    @Test
//    public void setNextTireRotationMiles(){
//        Vehicle vehicle = new Vehicle();
//        int expected = 25000;
//        vehicle.setNextTireRotationMiles();
//        int actual = vehicle.getVehicleMiles();
//        assertEquals(expected, actual);
//    }

}