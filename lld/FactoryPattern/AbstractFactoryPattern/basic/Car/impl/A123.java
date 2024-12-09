package basic.Car.impl;

import basic.Car.IMercedes;

public class A123 implements IMercedes {

    private final String model;
    private final int price;

    public A123(int price, String model) {
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
        return "A123{" +
                "model='" + model + '\'' +
                ", price=" + price +
                '}';
    }
}
