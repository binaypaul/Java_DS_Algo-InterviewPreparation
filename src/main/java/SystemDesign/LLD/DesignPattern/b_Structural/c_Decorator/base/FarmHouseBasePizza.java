package SystemDesign.LLD.DesignPattern.b_Structural.c_Decorator.base;

public class FarmHouseBasePizza implements BasePizza {
    private int cost;

    public FarmHouseBasePizza(int cost) {
        this.cost = cost;
    }

    @Override
    public int cost() {
        return this.cost;
    }
}
