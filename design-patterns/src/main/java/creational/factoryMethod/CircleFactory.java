package creational.factoryMethod;

public class CircleFactory implements Provider {

    public Shape produce() {
        return new Circle();
    }

}

