package strategy.impl;

import strategy.IDrive;

public class SportsDrive implements IDrive {

    @Override
    public void drive() {
        System.out.print("This is sports drive");
    }
}
