package vehicle;

import strategy.IDrive;

public class Vehicle {
    public IDrive drive;
    Vehicle(IDrive drive) {
        this.drive = drive;
    }
}