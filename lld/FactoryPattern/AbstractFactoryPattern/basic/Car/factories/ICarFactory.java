package basic.Car.factories;

import basic.Car.ICar;

public interface ICarFactory {
    public ICar getCar(String modelName) throws Exception;
}
