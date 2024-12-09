package ToppingsDecorator;

import Pizza.IBasePizza;

public abstract class Toppings implements IBasePizza {

    protected IBasePizza iBasePizza;

    Toppings(IBasePizza iBasePizza) {
        this.iBasePizza = iBasePizza;
    }
}
