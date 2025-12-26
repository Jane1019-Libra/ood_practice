package ca.janelu.ood._02_parking;

import java.util.ArrayList;
import java.util.List;

public class ParkingGarage {
    private ParkingFloor[] floors;

    public ParkingGarage(int floorCount, int spotPerFloor) {
        this.floors = new ParkingFloor[floorCount];
        for (int i = 0; i < floorCount; ++i) {
            floors[i] = new ParkingFloor(spotPerFloor);
        }
    }

    public boolean parkVechicle(Vehicle vehicle) {
        for (ParkingFloor floor: floors) {
            if (floor.parkingVehicle(vehicle)) return true;
        }
        return false;
    }

    public boolean removeVehicle(Vehicle vehicle, boolean firstCheck) {
        for (ParkingFloor floor : floors) {
            if (floor.getVehicleSpots(vehicle) != null) {
                if (firstCheck) return true;
                floor.removingVehicle(vehicle);
                return true;
            }
        }
        return false;
    }
}
