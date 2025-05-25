package SystemDesign.LLD.DesignPattern.e_AbstractFactory.AreaFactory;

public class CircleArea implements Area {
    private double radius;

    public CircleArea(double radius) {
        this.radius = radius;
    }
    @Override
    public void area() {
        System.out.println(((double) 22 /7) * Math.pow(radius, 2));
    }
}
