package ToppingsDecorator;

import Pizza.IBasePizza;

public class JalepenoToppings extends Toppings{

    public JalepenoToppings(IBasePizza iBasePizza) {
        super(iBasePizza);
    }
    @Override
    public int cost() {
        return iBasePizza.cost() + 50;
    }
}
