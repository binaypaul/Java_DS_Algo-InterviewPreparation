package SystemDesign.LLD.DesignPattern.a_Creational.d_AbstractFactory;

import SystemDesign.LLD.DesignPattern.a_Creational.d_AbstractFactory.AbstractFactory.AreaShapeAbstractFactory;
import SystemDesign.LLD.DesignPattern.a_Creational.d_AbstractFactory.AbstractFactory.AreaShapeAbstractFactoryImpl;
import SystemDesign.LLD.DesignPattern.a_Creational.d_AbstractFactory.AreaFactory.Area;
import SystemDesign.LLD.DesignPattern.a_Creational.d_AbstractFactory.AreaFactory.AreaFactory;

public class Usage {
    public static void main(String[] args) throws IllegalAccessException {
        AreaShapeAbstractFactory abstractFactory = new AreaShapeAbstractFactoryImpl();
        AreaFactory areaFactory = (AreaFactory) abstractFactory.getFactory("area");
        Area area = areaFactory.getArea("rectangle", 10, 5);
        area.area();
        area = areaFactory.getArea("circle", 1);
        area.area();
    }
}
