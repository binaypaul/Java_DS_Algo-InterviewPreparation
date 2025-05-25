package SystemDesign.LLD.DesignPattern.e_AbstractFactory.ShapeFactory;

import SystemDesign.LLD.DesignPattern.e_AbstractFactory.AbstractFactory.AreaShapeFactory;

public interface ShapeFactory extends AreaShapeFactory {
    Shape createShape(String type) throws IllegalAccessException;
}
