package ToppingsDecorator;

import Pizza.IBasePizza;

public class PaneerToppings extends Toppings{

    public PaneerToppings(IBasePizza iBasePizza) {
        super(iBasePizza);
    }

    @Override
    public int cost() {
        return iBasePizza.cost() + 10;
    }
}
