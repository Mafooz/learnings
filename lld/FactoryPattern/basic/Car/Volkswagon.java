package Car;

public class Volkswagon implements ICar {

    private final int price;

    private final String model;

    @Override
    public String toString() {
        return "Volkswagon{" +
                "price=" + price +
                ", model='" + model + '\'' +
                ", type= Volkswagon " +
                '}';
    }

    public Volkswagon(int price, String model) {
        this.price = price;
        this.model = model;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public String getModel() {
        return model;
    }

    @Override
    public String getType() {
        return "Volkswagon";
    }
}
