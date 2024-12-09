import models.Ride;
import models.RideController;
import models.User;

import java.util.ArrayList;
import java.util.List;

public class RideSharingApplication {

    List<User> users;
    RideController rideController;

    RideSharingApplication() {
        this.users = new ArrayList<>();
        rideController = new RideController();
    }

    // Add users
    public void addUser(User user) {
        users.add(user);
    }

    public Ride createRide(User user, String origin, String destination, double fair) {
        System.out.println("Creating ride for user " + user.getName());
        Ride ride = user.createRide(origin, destination, fair);
        if (ride==null) {
            return null;
        }
        rideController.addNewRide(ride);
        return ride;
    }

    public List<Ride> getPossibleRides(String origin, String destination) {
        return rideController.selectARide(origin, destination);
    }

    public Ride getLeastFareRide(String origin, String destination) {
        List<Ride> rides =  rideController.selectARide(origin, destination);
        if (rides.isEmpty()) {
            System.out.println("No rides found!!");
            return null;
        }
        Ride leastFareRide = rides.getFirst();
        double amount = rides.getFirst().getFair();
        for(Ride ride: rides) {
            if (amount>ride.getFair()) {
                amount=ride.getFair();
                leastFareRide = ride;
            }
        }
        return leastFareRide;
    }
    public void acceptRide(User user, Ride ride) {
        ride.acceptAPassenger(user);
    }

    public void endARide(Ride ride) {
        ride.endRide();
        rideController.removeARide(ride);
    }

    public List<Ride> offeredRidesByAUser(User user) {
        return user.getOfferedRides();
    }
    // total rides offered/taken by a user
    public List<Ride> acceptedRidesByAUser(User user) {
        return user.getAcceptedRides();
    }

}
