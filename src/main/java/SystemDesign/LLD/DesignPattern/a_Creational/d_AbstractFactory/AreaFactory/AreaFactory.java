package SystemDesign.LLD.DesignPattern.a_Creational.d_AbstractFactory.AreaFactory;

import SystemDesign.LLD.DesignPattern.a_Creational.d_AbstractFactory.AbstractFactory.AreaShapeFactory;

public interface AreaFactory extends AreaShapeFactory {
    Area getArea(String type, double... params) throws IllegalAccessException;
}
