package SystemDesign.LLD.DesignPattern.d_Factory;

public class ShapeFactoryImpl implements ShapeFactory {
    @Override
    public Shape createShape(String type) throws IllegalAccessException {
        switch (type) {
            case "circle":
                return new Circle();
            case "rectangle":
                return new Rectangle();
            default:
                throw new IllegalAccessException("Invalid shape type.");
        }
    }
}
