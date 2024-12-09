package basic.Car.impl;

import basic.Car.IMaruti;

public class Brezza implements IMaruti {

    private final String model;
    private final int price;

    public Brezza(int price, String model) {
        this.price = price;
        this.model = model;
    }
    public String getType() {
        return "Maruti";
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
        return "Brezza{" +
                "model='" + model + '\'' +
                ", price=" + price +
                '}';
    }
}
