package models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RideController {

    Map<String, Ride> offeredRides;


    public RideController() {
        offeredRides = new HashMap<>();
    }
    public void addNewRide(Ride ride) {
        offeredRides.put(ride.getId(), ride);
    }

    public void removeARide(Ride ride) {
        offeredRides.remove(ride.getId());
    }

    public List<Ride> selectARide(String origin, String destination) {
        List<Ride> rides = new ArrayList<>();
        for(String rideId: offeredRides.keySet()) {
            Ride ride = offeredRides.get(rideId);
            if (ride.getRideStatus()==RideStatus.ACCEPTING && ride.getOrigin().equals(origin) && ride.getDestination().equals(destination)) {
                rides.add(ride);
            }
        }
        return rides;
    }
}
