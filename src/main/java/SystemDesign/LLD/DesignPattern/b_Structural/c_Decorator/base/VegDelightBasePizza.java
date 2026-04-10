package SystemDesign.LLD.DesignPattern.b_Structural.c_Decorator.base;

public class VegDelightBasePizza implements BasePizza {
    private int cost;

    public VegDelightBasePizza(int cost) {
        this.cost = cost;
    }

    @Override
    public int cost() {
        return this.cost;
    }
}
