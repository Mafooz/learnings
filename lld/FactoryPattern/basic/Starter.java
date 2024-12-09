import Car.CarFactory;
import Car.ICar;
public class Starter {
    public static void main(String[] args) {
        ICar ICar1 = CarFactory.getCar(20000);
        System.out.println(ICar1);
        ICar ICar2 = CarFactory.getCar(10000);
        System.out.println(ICar2);
        ICar ICar3 = CarFactory.getCar(5000);
        System.out.println(ICar3);
    }
}
