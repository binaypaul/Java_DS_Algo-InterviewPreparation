package SystemDesign.LLD.DesignPattern.d_Factory;

public class Main {
    public static void main(String[] args) throws IllegalAccessException {
        new ShapeFactoryImpl().createShape("circle").draw();
    }
}
