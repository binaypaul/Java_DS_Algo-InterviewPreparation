package SystemDesign.LLD.DesignPattern.e_AbstractFactory.AreaFactory;

import SystemDesign.LLD.DesignPattern.e_AbstractFactory.AbstractFactory.AreaShapeFactory;

public interface AreaFactory extends AreaShapeFactory {
    Area getArea(String type, double... params) throws IllegalAccessException;
}
