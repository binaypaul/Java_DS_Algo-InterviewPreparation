package SystemDesign.LLD.DesignPattern.e_AbstractFactory.AreaFactory;

public class AreaFactoryImpl implements AreaFactory {
    @Override
    public Area getArea(String type, double... params) throws IllegalAccessException {
        switch (type) {
            case "circle":
                if(params.length != 1)
                    throw new IllegalAccessException("Exactly one radius param required.");
                return new CircleArea(params[0]);
            case "rectangle":
                if(params.length != 2)
                    throw new IllegalAccessException("Exactly one length and one breadth param required respectively.");
                return new RectangleArea(params[0], params[1]);
            default:
                throw new IllegalAccessException("Invalid shape type.");
        }
    }
}
