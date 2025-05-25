package SystemDesign.LLD.DesignPattern.e_AbstractFactory.AbstractFactory;

public interface AreaShapeAbstractFactory {
    AreaShapeFactory getFactory(String type) throws IllegalAccessException;
}
