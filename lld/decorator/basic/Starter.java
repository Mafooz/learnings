import Pizza.IBasePizza;
import Pizza.impl.Margarita;
import Pizza.impl.VeggieDelight;
import ToppingsDecorator.JalepenoToppings;
import ToppingsDecorator.PaneerToppings;

public class Starter {

    public static void main(String args[]) {
        IBasePizza margaritaWithPaneerToppingsPizza = new PaneerToppings(new Margarita());
        System.out.println(margaritaWithPaneerToppingsPizza.cost());
        IBasePizza allTopings = new JalepenoToppings(margaritaWithPaneerToppingsPizza);
        System.out.println(allTopings.cost());
        IBasePizza veggieWithJalepenoPizza = new JalepenoToppings(new VeggieDelight());
        System.out.println(veggieWithJalepenoPizza.cost());
    }
}
