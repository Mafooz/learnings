package models;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Ride {
    private final String id;
    private User offeredBy;
    private String origin;
    private String destination;
    private double fair;
    private RideStatus rideStatus;
    private List<User> riddenBy;

    public Ride(User offeredBy, String origin, String destination, double fair) {
        this.id = UUID.randomUUID().toString();
        this.offeredBy = offeredBy;
        this.origin = origin;
        this.destination = destination;
        this.fair = fair;
        riddenBy = new ArrayList<>();
        rideStatus = RideStatus.ACCEPTING;
    }

    public String getId() {
        return id;
    }

    public User getOfferedBy() {
        return offeredBy;
    }

    public void setOfferedBy(User offeredBy) {
        this.offeredBy = offeredBy;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public double getFair() {
        return fair;
    }

    public void setFair(double fair) {
        this.fair = fair;
    }

    public RideStatus getRideStatus() {
        return rideStatus;
    }

    public void setRideStatus(RideStatus rideStatus) {
        this.rideStatus = rideStatus;
    }

    public boolean acceptAPassenger(User user) {
        if (rideStatus==RideStatus.ACCEPTING) {
            riddenBy.add(user);
            if (riddenBy.size()==offeredBy.getVehicle().getCapacity()) {
                rideStatus = RideStatus.FILLED;
                startRide();
            }
            return true;
        }
        return false;
    }
    public void startRide() {
        setRideStatus(RideStatus.STARTED);
        System.out.println("models.Ride started!!!");
    }

    public void endRide() {
        setRideStatus(RideStatus.COMPLETED);
        this.getOfferedBy().getVehicle().setVehicleStatus(VehicleStatus.FREE);
        this.getOfferedBy().setUserStatus(UserStatus.FREE);
        this.getOfferedBy().addRideToOfferedList(this);
        for(User user: riddenBy) {
            user.addRideToAcceptedList(this);
            user.setUserStatus(UserStatus.FREE);
        }
        System.out.println("models.Ride completed!!!");
    }
}
