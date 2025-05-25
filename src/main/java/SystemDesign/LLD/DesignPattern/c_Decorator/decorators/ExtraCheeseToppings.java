package SystemDesign.LLD.DesignPattern.c_Decorator.decorators;

import SystemDesign.LLD.DesignPattern.c_Decorator.base.BasePizza;

public class ExtraCheeseToppings implements Toppings{
    BasePizza basePizza;

    public ExtraCheeseToppings(BasePizza pizza) {
        this.basePizza = pizza;
    }

    @Override
    public int cost() {
        return this.basePizza.cost() + 50;
    }
}
