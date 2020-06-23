package creational.simpleFactory;

public class Main {

    public static void main(String[] args) {
        Shape circle = ShapeFactory.getShape("Circle");
        circle.draw();
    }

}
