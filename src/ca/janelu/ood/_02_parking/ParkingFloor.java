package ca.janelu.ood._02_parking;

import java.util.HashMap;
import java.util.Map;

public class ParkingFloor {
    private int[] spots;
    private Map<Vehicle, int[]> vehicleMap;

    public ParkingFloor(int spotPerFloor) {
        spots = new int[spotPerFloor];
        vehicleMap = new HashMap<>();
    }

    public boolean parkingVehicle(Vehicle vehicle) {
        int size = vehicle.getSpotSize();
        int l = 0, r = 0;
        while (r < spots.length) {
            if (spots[r] != 0) {
                l = r + 1;
            }
            if (r - l + 1 == size) {
                for (int i = l; i <= r; i++) {
                    spots[i] = 1;
                }

                vehicleMap.put(vehicle, new int[]{l, r});
                return true;
            }
            r++;
        }
        return false;
    }

    public void removingVehicle(Vehicle vehicle) {
        int[] startEnd = vehicleMap.get(vehicle);
        int start = startEnd[0];
        int end = startEnd[1];
        for (int i = start; i <= end; i++) {
            spots[i] = 0;
        }

        vehicleMap.remove(vehicle);
    }

    public int[] getVehicleSpots(Vehicle vehicle) {
        return vehicleMap.get(vehicle);
    }
}
