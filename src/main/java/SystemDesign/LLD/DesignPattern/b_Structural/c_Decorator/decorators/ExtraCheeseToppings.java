package SystemDesign.LLD.DesignPattern.b_Structural.c_Decorator.decorators;

import SystemDesign.LLD.DesignPattern.b_Structural.c_Decorator.base.BasePizza;

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
