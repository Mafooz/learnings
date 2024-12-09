import strategy.impl.SportsDrive;
import vehicle.NormalVehicle;
import vehicle.SportsVehicle;

public class Main {
    public static void main(String[] args) {
        NormalVehicle normalVehicle = new NormalVehicle();
        normalVehicle.drive();
        SportsVehicle sportsVehicle = new SportsVehicle();
        sportsVehicle.drive();
    }
}
