package vehicle;

import strategy.impl.SportsDrive;

public class SportsVehicle extends Vehicle {
    public SportsVehicle() {
        super(new SportsDrive());
    }

    public void drive() {
        drive.drive();
    }
}
