package basic.Car.factories;

import basic.Car.IMercedes;
import basic.Car.impl.A123;
import basic.Car.impl.B123;

public class MercedesFactory implements ICarFactory{

    private static MercedesFactory mercedesFactory = null;
    private MercedesFactory() {
    }

    public static MercedesFactory getInstance() {
        if (mercedesFactory==null) {
            mercedesFactory = new MercedesFactory();
        }
        return mercedesFactory;
    }
    public IMercedes getCar(String modelName) throws Exception{
        if ("A123".equals(modelName)) {
            return new A123(10000, "Luxury");
        }
        else if ("B123".equals(modelName)) {
            return new B123(12000, "Super Luxury");
        }
        else {
            throw new Exception("Invalid model name");
        }
    }
}
