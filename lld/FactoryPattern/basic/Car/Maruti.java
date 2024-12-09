package Car;

public class Maruti implements ICar {

    private final int price;

    private final String model;

    @Override
    public String toString() {
        return "Maruti{" +
                "price=" + price +
                ", model='" + model + '\'' +
                ", type= Maruti " +
                '}';
    }

    Maruti(int price, String model) {
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
        return "Maruti";
    }
}
