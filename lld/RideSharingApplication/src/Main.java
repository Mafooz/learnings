import models.Ride;
import models.User;
import models.Vehicle;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        User user1 = new User("user1", new Vehicle(1, "reg1"));
        User user2 = new User("user2", new Vehicle(2, "reg1"));
        User user3 = new User("user3", new Vehicle(1, "reg1"));
        User user4 = new User("user4", new Vehicle(1, "reg1"));
        User user5 = new User("user5", null);
        User user6 = new User("user6", new Vehicle(10, "reg1"));
        User user7 = new User("user7", null);
        User user8 = new User("user8", null);
        User user9 = new User("user9", null);

        RideSharingApplication rideSharingApplication = new RideSharingApplication();
        rideSharingApplication.addUser(user1);
        rideSharingApplication.addUser(user2);
        rideSharingApplication.addUser(user3);
        rideSharingApplication.addUser(user4);
        rideSharingApplication.addUser(user5);
        rideSharingApplication.addUser(user6);

        Ride ride1 = rideSharingApplication.createRide(user1, "HP", "UP", 500.0);
        Ride ride2 = rideSharingApplication.createRide(user1, "HP", "UP", 100.0);
        Ride ride3 = rideSharingApplication.createRide(user3, "HP", "UP", 100.0);
        Ride ride4 = rideSharingApplication.createRide(user2, "UP", "HP", 400.0);

        List<Ride> rides = rideSharingApplication.getPossibleRides("HP", "UP");
        System.out.println("Rides are");
        for(Ride ride: rides) {
            System.out.println("rideid is " + ride.getId());
        }
        rides = rideSharingApplication.getPossibleRides("UP", "HP");
        System.out.println("Rides are");
        for(Ride ride: rides) {
            System.out.println("rideid is " + ride.getId());
        }
        System.out.println("---------------------");
        Ride ride = rideSharingApplication.getLeastFareRide("HP", "UP");
        System.out.println(ride.getId() + " " + ride.getFair());
        System.out.println(ride.getRideStatus());
        rideSharingApplication.acceptRide(user5, ride);
        System.out.println(ride.getRideStatus());
        rideSharingApplication.acceptRide(user5, ride);
        System.out.println(ride.getRideStatus());
        Ride ride5 = rideSharingApplication.getLeastFareRide("HP", "UP");
        System.out.println(ride5.getId() + ride5.getFair());
        System.out.println(ride5.getRideStatus());
        rideSharingApplication.acceptRide(user6, ride5);
        System.out.println(ride5.getRideStatus());
        for(User user: rideSharingApplication.users) {
            System.out.println("User id" + user.getId());
            System.out.println(user.getAcceptedRides().size());
            System.out.println(user.getOfferedRides().size());
        }
        ride5.endRide();
        ride.endRide();
        ride4.endRide();
        for(User user: rideSharingApplication.users) {
            System.out.println("User name" + user.getName());
            System.out.println(user.getAcceptedRides().size());
            System.out.println(user.getOfferedRides().size());
        }
    }
}
