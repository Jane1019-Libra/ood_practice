package ca.janelu.ood._02_parking;

public class Main {
    public static void main(String[] args) {
        ParkingGarage parkingGarage = new ParkingGarage(3, 10);
        ParkingSystem parkingSyatem = new ParkingSystem(parkingGarage, 10);
        Driver driver1 = new Driver(new Car(1),1);
        Driver driver2 = new Driver(new Limo(1),2);
        Driver driver3 = new Driver(new SemiTruck(1),3);
        System.out.println(parkingSyatem.parkVechicle(driver1));
        System.out.println(parkingSyatem.parkVechicle(driver2));
        System.out.println(parkingSyatem.parkVechicle(driver3));
    }
}
