package basic.Car.impl;

import basic.Car.IVolkswagon;

public class Polo implements IVolkswagon {

    private final String model;
    private final int price;

    public Polo(int price, String model) {
        this.price = price;
        this.model = model;
    }
    public String getType() {
        return "Volkswagon";
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Polo{" +
                "model='" + model + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public String getModelName() {
        return model;
    }
}
