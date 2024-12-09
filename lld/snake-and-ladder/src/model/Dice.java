package model;

import java.util.Random;

public class Dice {
    private int maxVal;
    public Dice() {
        maxVal = 6;
    }
    public Dice(int val) {
        maxVal = val;
    }

    public int getRandomValue() {
        return new Random().nextInt(maxVal)+1;
    }
}
