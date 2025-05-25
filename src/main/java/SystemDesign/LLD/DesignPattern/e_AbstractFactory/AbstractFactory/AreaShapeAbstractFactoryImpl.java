package SystemDesign.LLD.DesignPattern.e_AbstractFactory.AbstractFactory;

import SystemDesign.LLD.DesignPattern.e_AbstractFactory.AreaFactory.AreaFactoryImpl;
import SystemDesign.LLD.DesignPattern.e_AbstractFactory.ShapeFactory.ShapeFactoryImpl;

public class AreaShapeAbstractFactoryImpl implements AreaShapeAbstractFactory {
    @Override
    public AreaShapeFactory getFactory(String type) throws IllegalAccessException {
        switch (type) {
            case "shape":
                return new ShapeFactoryImpl();
            case "area":
                return new AreaFactoryImpl();
            default:
                throw new IllegalAccessException("Invalid shape type.");
        }
    }
}
