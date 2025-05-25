package SystemDesign.LLD.DesignPattern.e_AbstractFactory.ShapeFactory;

public class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a circle.");
    }
}
