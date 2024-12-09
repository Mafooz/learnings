package basic.Car.impl;

import basic.Car.IVolkswagon;

public class Vento implements IVolkswagon {

    private final String model;
    private final int price;

    public Vento(int price, String model) {
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
    public String getModelName() {
        return model;
    }

    @Override
    public String toString() {
        return "Vento{" +
                "model='" + model + '\'' +
                ", price=" + price +
                '}';
    }
}
