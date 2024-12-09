package vehicle;

import strategy.IDrive;
import strategy.impl.NormalDrive;

public class NormalVehicle extends Vehicle {

    public NormalVehicle() {
        super(new NormalDrive());
    }
    public void drive() {
        drive.drive();
    }
}
