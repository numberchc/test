package creational.factoryMethod;

public class SquareFactory implements Provider {

    public Shape produce() {
        return new Square();
    }

}
