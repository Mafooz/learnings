package Car;

public class Mercedes implements ICar {

    private final int price;

    private final String model;

    @Override
    public String toString() {
        return "Mercedes{" +
                "price=" + price +
                ", model='" + model + '\'' +
                ", type= Mercedes " +
                '}';
    }

    public Mercedes(int price, String model) {
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
        return "Mercedes";
    }
}
