package creational.abstractFactory;

//抽象工厂
public interface AbstractFactory {

    //生产空调
    IAirConditioner createAirConditoner();

    //生产冰箱
    IRefrigerator createRefrigerator();

}
