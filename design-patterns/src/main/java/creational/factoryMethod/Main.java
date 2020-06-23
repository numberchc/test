package creational.factoryMethod;

public class Main {

    public static void main(String[] args) {
        Provider circleProvider = new CircleFactory();
        Shape circle = circleProvider.produce();
        circle.draw();
        Provider squareProvider = new SquareFactory();
        Shape square = squareProvider.produce();
        square.draw();
    }

}
