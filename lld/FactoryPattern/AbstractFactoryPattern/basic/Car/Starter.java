package basic.Car;

import basic.Car.factories.CarFactory;
import basic.Car.factories.ICarFactory;
import basic.Car.ICar;
public class Starter {
    public static void main(String[] args) throws Exception {
        ICarFactory carFactory = CarFactory.getFactory("Maruti");
        ICar car = carFactory.getCar("Zen");
        System.out.println(car);
        car = CarFactory.getFactory("Mercedes").getCar("A123");
        System.out.println(car);

    }
}
