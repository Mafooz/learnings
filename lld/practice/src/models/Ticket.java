package models;

import java.util.Date;
import java.util.UUID;

public class Ticket {

    private String id;
    private Vehicle vehicle;
    private ParkingSpot parkingSpot;
    private boolean isValid;
    private Date generatedTime;
    private Date exitTime;

    public Ticket(Vehicle vehicle, ParkingSpot parkingSpot) {
        this.id = UUID.randomUUID().toString();
        this.vehicle = vehicle;
        this.parkingSpot = parkingSpot;
        this.isValid = true;
        generatedTime = new Date();
        exitTime = null;
    }

    public String getId() {
        return id;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }

    public void setParkingSpot(ParkingSpot parkingSpot) {
        this.parkingSpot = parkingSpot;
    }

    public boolean isValid() {
        return isValid;
    }

    public void setValid(boolean valid) {
        isValid = valid;
    }

    public Date getGeneratedTime() {
        return generatedTime;
    }

    public void setExitTime(Date exitTime) {
        this.exitTime = exitTime;
    }

    public Date getExitTime() {
        return exitTime;
    }
}
