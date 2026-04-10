package SystemDesign.LLD.DesignPattern.a_Creational.a_Factory;

public interface ShapeFactory {
    Shape createShape(String type) throws IllegalAccessException;
}
