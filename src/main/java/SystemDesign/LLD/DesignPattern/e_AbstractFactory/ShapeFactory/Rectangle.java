package SystemDesign.LLD.DesignPattern.e_AbstractFactory.ShapeFactory;

public class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a rectangle.");
    }
}
