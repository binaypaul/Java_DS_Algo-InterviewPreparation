package SystemDesign.LLD.DesignPattern.a_Creational.d_AbstractFactory.AbstractFactory;

public interface AreaShapeAbstractFactory {
    AreaShapeFactory getFactory(String type) throws IllegalAccessException;
}
