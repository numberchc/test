package creational.abstractFactory;

public class HaierFactory implements AbstractFactory{

    public IAirConditioner createAirConditoner() {
        return new HaierAirConditioner();
    }

    public IRefrigerator createRefrigerator() {
        return new HaierRefrigerator();
    }

}
