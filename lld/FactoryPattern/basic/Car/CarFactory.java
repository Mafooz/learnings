package Car;

public class CarFactory {

    public static ICar getCar(int price) {
        if (price<10000) {
            return new Maruti(price, "Brezza");
        }
        else if (price<20000) {
            return new Volkswagon(price, "Polo");
        }
        else {
            return new Mercedes(price, "ACE123");
        }
    }
}
