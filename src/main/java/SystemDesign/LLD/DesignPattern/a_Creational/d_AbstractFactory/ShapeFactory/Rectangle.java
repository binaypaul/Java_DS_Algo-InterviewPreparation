package SystemDesign.LLD.DesignPattern.a_Creational.d_AbstractFactory.ShapeFactory;

public class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a rectangle.");
    }
}
