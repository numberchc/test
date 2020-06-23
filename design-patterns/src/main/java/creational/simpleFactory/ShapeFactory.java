package creational.simpleFactory;

public class ShapeFactory {

    public static Shape getShape(String shapeType) {
        if (shapeType == null) {
            return null;
        }
        if ("Circle".equals(shapeType)) {
            return new Circle();
        } else if ("Rectangle".equals(shapeType)) {
            return new Rectangle();
        } else if ("Square".equals(shapeType)) {
            return new Square();
        }
        return null;
    }

}
