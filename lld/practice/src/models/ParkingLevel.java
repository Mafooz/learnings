package models;

import java.util.ArrayList;
import java.util.List;

public class ParkingLevel {

    private List<ParkingSpot> parkingSpotList;

    public ParkingLevel(List<VehicleType> vehicleTypesSpots) {
        parkingSpotList = new ArrayList<>();
        for(VehicleType vehicleType: vehicleTypesSpots) {
            parkingSpotList.add(new ParkingSpot(vehicleType));
        }
    }

    public ParkingSpot getAnEmptySpot(VehicleType vehicleType) {
        for(ParkingSpot parkingSpot: parkingSpotList) {
            if (!parkingSpot.isOccupied && parkingSpot.getVehicleType().equals(vehicleType)) {
                return parkingSpot;
            }
        }
        return null;
    }
}
