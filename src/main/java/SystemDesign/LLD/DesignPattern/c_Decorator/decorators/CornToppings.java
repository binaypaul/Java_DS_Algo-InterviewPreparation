package SystemDesign.LLD.DesignPattern.c_Decorator.decorators;

import SystemDesign.LLD.DesignPattern.c_Decorator.base.BasePizza;

public class CornToppings implements Toppings {
    BasePizza basePizza;

    public CornToppings(BasePizza basePizza) {
        this.basePizza = basePizza;
    }

    @Override
    public int cost() {
        return this.basePizza.cost() + 10;
    }
}
