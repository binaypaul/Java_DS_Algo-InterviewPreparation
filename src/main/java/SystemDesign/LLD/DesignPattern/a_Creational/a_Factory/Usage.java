package SystemDesign.LLD.DesignPattern.a_Creational.a_Factory;

public class Usage {
    public static void main(String[] args) throws IllegalAccessException {
        new ShapeFactoryImpl().createShape("circle").draw();
    }
}
