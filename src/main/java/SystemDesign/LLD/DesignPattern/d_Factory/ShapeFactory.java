package SystemDesign.LLD.DesignPattern.d_Factory;

public interface ShapeFactory {
    Shape createShape(String type) throws IllegalAccessException;
}
