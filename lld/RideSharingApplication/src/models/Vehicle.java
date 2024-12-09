package models;

import java.util.UUID;

public class Vehicle {

    private final String id;
    private VehicleStatus vehicleStatus;
    private int capacity;

    private String regNo;

    public Vehicle(int capacity, String regNo) {
        this.id = UUID.randomUUID().toString();
        vehicleStatus = VehicleStatus.FREE;
        this.capacity = capacity;
        this.regNo = regNo;
    }

    public VehicleStatus getVehicleStatus() {
        return vehicleStatus;
    }

    public void setVehicleStatus(VehicleStatus vehicleStatus) {
        this.vehicleStatus = vehicleStatus;
    }

    public String getId() {
        return id;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getRegNo() {
        return regNo;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }
}
