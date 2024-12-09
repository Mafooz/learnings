package basic.Car.factories;

import basic.Car.ICar;
import basic.Car.IMaruti;
import basic.Car.impl.Brezza;
import basic.Car.impl.Zen;

public class MarutiFactory implements ICarFactory{

    private static MarutiFactory marutiFactory = null;
    private MarutiFactory() {
    }

    public static MarutiFactory getInstance() {
        if (marutiFactory==null) {
            marutiFactory = new MarutiFactory();
        }
        return marutiFactory;
    }
    public IMaruti getCar(String modelName) throws Exception{
        if ("Zen".equals(modelName)) {
            return new Zen(2000, "LX");
        }
        else if ("Brezza".equals(modelName)) {
            return new Brezza(2000, "XCX");
        }
        else {
            throw new Exception("Invalid model name");
        }
    }
}
