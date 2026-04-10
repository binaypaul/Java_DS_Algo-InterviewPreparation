package SystemDesign.LLD.DesignPattern.a_Creational.d_AbstractFactory.AreaFactory;

public class RectangleArea implements Area {
    private double length;
    private double breadth;

    public RectangleArea(double length, double breadth) {
        this.length = length;
        this.breadth = breadth;
    }

    @Override
    public void area() {
        System.out.println(length*breadth);
    }
}
