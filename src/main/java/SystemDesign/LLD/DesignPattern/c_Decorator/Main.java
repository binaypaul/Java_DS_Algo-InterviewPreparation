package SystemDesign.LLD.DesignPattern.c_Decorator;

import SystemDesign.LLD.DesignPattern.c_Decorator.base.BasePizza;
import SystemDesign.LLD.DesignPattern.c_Decorator.base.VegDelightBasePizza;
import SystemDesign.LLD.DesignPattern.c_Decorator.decorators.CornToppings;
import SystemDesign.LLD.DesignPattern.c_Decorator.decorators.ExtraCheeseToppings;
import SystemDesign.LLD.DesignPattern.c_Decorator.decorators.Toppings;

public class Main {
    public static void main(String[] args) {
        BasePizza basePizza = new VegDelightBasePizza(100);
        System.out.println(basePizza.cost());

        Toppings toppings1 = new ExtraCheeseToppings(basePizza);
        System.out.println(toppings1.cost());

        Toppings toppings2 = new CornToppings(toppings1);
        System.out.println(toppings2.cost());

        //in single line
        BasePizza pizza = new CornToppings(new ExtraCheeseToppings(new VegDelightBasePizza(100)));
        System.out.println(pizza.cost());
    }
}