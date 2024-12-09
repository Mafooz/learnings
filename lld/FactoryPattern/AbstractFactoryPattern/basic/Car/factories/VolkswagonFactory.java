package basic.Car.factories;

import basic.Car.IVolkswagon;
import basic.Car.impl.Polo;
import basic.Car.impl.Vento;

public class VolkswagonFactory implements ICarFactory{

    private static VolkswagonFactory volkswagonFactory = null;
    private VolkswagonFactory() {
    }

    public static VolkswagonFactory getInstance() {
        if (volkswagonFactory==null) {
            volkswagonFactory = new VolkswagonFactory();
        }
        return volkswagonFactory;
    }
    public IVolkswagon getCar(String modelName) throws Exception{
        if ("Polo".equals(modelName)) {
            return new Polo(4000, "LX");
        }
        else if ("Vento".equals(modelName)) {
            return new Vento(5000, "XCX");
        }
        else {
            throw new Exception("Invalid model name");
        }
    }
}
