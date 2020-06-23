package creational.factoryMethod;

public class RectangleFactory implements Provider {

    public Shape produce() {
        return new Rectangle();
    }

}
