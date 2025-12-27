package ca.janelu.ood._02_parking;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ParkingSystem {
    private ParkingGarage parkingGarage;
    private Map<Integer, Integer> timeParked;
    private int hourRate;

    private Scanner scanner = new Scanner(System.in);

    public ParkingSystem(ParkingGarage parkingGarage, int hourRate) {
        this.parkingGarage = parkingGarage;
        this.timeParked = new HashMap<>();
        this.hourRate = hourRate;
    }

    public boolean parkVehicle(Driver driver) {
        int currentHour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
        boolean isParked = parkingGarage.parkVechicle(driver.getVehicle());
        if (isParked) {
            timeParked.put(driver.getId(), currentHour);
        }
        return isParked;
    }

    public boolean removeVehicle(Driver driver) {
        int currentHour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
        System.out.println(currentHour);
        boolean existed = parkingGarage.removeVehicle(driver.getVehicle(), true);
        if (!existed) {
            System.out.println("There is no car parked for id: " + driver.getId());
            return false;
        }


        boolean removed = parkingGarage.removeVehicle(driver.getVehicle(), false);
        timeParked.remove(driver.getId());
        return removed;
    }
}
