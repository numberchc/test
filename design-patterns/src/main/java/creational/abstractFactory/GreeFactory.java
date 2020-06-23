package creational.abstractFactory;

public class GreeFactory implements AbstractFactory {

    public IAirConditioner createAirConditoner() {
        return new GreeAirConditioner();
    }

    public IRefrigerator createRefrigerator() {
        return new GreeRefrigerator();
    }

}
