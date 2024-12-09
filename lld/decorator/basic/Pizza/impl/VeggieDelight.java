package Pizza.impl;

import Pizza.IBasePizza;

public class VeggieDelight implements IBasePizza {

    @Override
    public int cost() {
        return 100;
    }
}
