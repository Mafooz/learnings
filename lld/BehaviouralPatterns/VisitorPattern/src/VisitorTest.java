public class VisitorTest {
    public static void main(String [] args) {
        TaxVisitor taxVisitor = new TaxVisitor();
        Liqour beer = new Liqour(200, "Beer", taxVisitor);
        Liqour tequila = new Liqour(300, "Tequila", taxVisitor);

        Necessity notebook = new Necessity(100, "Notebook", taxVisitor);
        Necessity coffeeMug = new Necessity(150, "CoffeeMug", taxVisitor);

        Food burger = new Food(250, "Burger", taxVisitor);
        Food pizza = new Food(450, "Pizza", taxVisitor);

        beer.calculateTax();
        tequila.calculateTax();
        notebook.calculateTax();
        coffeeMug.calculateTax();
        burger.calculateTax();
        pizza.calculateTax();
    }
}
