package basic.Car.impl;

import basic.Car.IMercedes;

public class B123 implements IMercedes {

    private final String model;
    private final int price;

    public B123(int price, String model) {
        this.price = price;
        this.model = model;
    }
    public String getType() {
        return "Mercedes";
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
        return "B123{" +
                "model='" + model + '\'' +
                ", price=" + price +
                '}';
    }
}
