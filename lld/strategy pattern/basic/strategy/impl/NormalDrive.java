package strategy.impl;

import strategy.IDrive;

public class NormalDrive implements IDrive {
    @Override
    public void drive() {
        System.out.print("This is normal drive");
    }
}
