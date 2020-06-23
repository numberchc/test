package creational.abstractFactory;

public class Main {

    public static void main(String[] args) {
        AbstractFactory greeFactory = new GreeFactory();
        AbstractFactory haierFactory = new HaierFactory();

        IAirConditioner greeAirConditioner = greeFactory.createAirConditoner();
        IRefrigerator greeRefrigerator = greeFactory.createRefrigerator();

        IAirConditioner haierAirConditioner = haierFactory.createAirConditoner();
        IRefrigerator haierRefrigerator = haierFactory.createRefrigerator();

        System.out.println("格力产品；");
        greeAirConditioner.cryogen();
        greeRefrigerator.preserveFood();

        System.out.println("海尔产品：");
        haierAirConditioner.cryogen();
        haierRefrigerator.preserveFood();
    }

}
