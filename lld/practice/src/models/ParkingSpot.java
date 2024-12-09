package models;

public class ParkingSpot {
    VehicleType vehicleType;
    boolean isOccupied;

    public ParkingSpot(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
        isOccupied = false;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }
}
