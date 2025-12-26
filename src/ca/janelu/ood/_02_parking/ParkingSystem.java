package ca.janelu.ood._02_parking;

import java.util.HashMap;
import java.util.Map;

public class ParkingSystem {
    private ParkingGarage parkingGarage;
    private Map<Integer, Integer> timeParked;
    private int hourRate;

    public ParkingSystem(ParkingGarage parkingGarage, int hourRate) {
        this.parkingGarage = parkingGarage;
        this.timeParked = new HashMap<>();
        this.hourRate = hourRate;
    }

    public boolean parkVechicle(Driver driver) {

    }

    public boolean removeVechicle(Driver driver) {

    }
}
