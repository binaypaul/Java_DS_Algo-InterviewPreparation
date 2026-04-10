package SystemDesign.LLD.DesignPattern.a_Creational.d_AbstractFactory.ShapeFactory;

import SystemDesign.LLD.DesignPattern.a_Creational.d_AbstractFactory.AbstractFactory.AreaShapeFactory;

public interface ShapeFactory extends AreaShapeFactory {
    Shape createShape(String type) throws IllegalAccessException;
}
