package models;

import java.awt.desktop.UserSessionEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class User {

    private final String id;
    private String name;
    private Vehicle vehicle;

    List<Ride> offeredRides;
    UserStatus userStatus;
    List<Ride> acceptedRides;

    public User(String name, Vehicle vehicle) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.vehicle = vehicle;
        offeredRides = new ArrayList<>();
        acceptedRides = new ArrayList<>();
        userStatus = UserStatus.FREE;
    }

    public UserStatus getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(UserStatus userStatus) {
        this.userStatus = userStatus;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public List<Ride> getOfferedRides() {
        return offeredRides;
    }

    public List<Ride> getAcceptedRides() {
        return acceptedRides;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public void addRideToOfferedList(Ride offeredRide) {
        this.offeredRides.add(offeredRide);
    }

    public void addRideToAcceptedList(Ride acceptedRide) {
        this.acceptedRides.add(acceptedRide);
    }

    public Ride createRide(String origin, String destination, double fair) {
        if (vehicle==null) {
            System.out.println("Can not offer a ride, you have no vehicle");
            return null;
        }
        if (vehicle.getVehicleStatus()==VehicleStatus.OCCUPIED) {
            System.out.println("Can not offer a ride, vehicle occupied");
            return null;
        }
        vehicle.setVehicleStatus(VehicleStatus.OCCUPIED);
        return new Ride(this, origin, destination, fair);
    }

    public void acceptRide(Ride ride) {
        if (!ride.acceptAPassenger(this)) {
            System.out.println("models.Ride filled!!!, try again");
            return;
        }
        System.out.println("models Ride accepted!!");
        userStatus = UserStatus.OCCUPIED;
    }
}
