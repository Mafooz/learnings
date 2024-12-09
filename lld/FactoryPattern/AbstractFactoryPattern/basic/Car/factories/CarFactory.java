package basic.Car.factories;

public class CarFactory {
    public static ICarFactory getFactory(String brandName) throws Exception{
        if ("Maruti".equals(brandName)) {
            return MarutiFactory.getInstance();
        }
        else if ("Mercedes".equals(brandName)) {
            return MercedesFactory.getInstance();
        }
        else if ("Volkswagon".equals(brandName)) {
            return VolkswagonFactory.getInstance();
        }
        else {
            throw new Exception("Invalid Brand");
        }
    }
}
