package ca.janelu.ood._02_parking;

public class Driver {
    private Vehicle vehicle;
    private int id;
    private int paymentDue;

    public Driver(Vehicle vehicle, int id) {
        this.vehicle = vehicle;
        this.id = id;
        this.paymentDue = 0;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPaymentDue() {
        return paymentDue;
    }

    public void setPaymentDue(int paymentDue) {
        this.paymentDue = paymentDue;
    }
}
