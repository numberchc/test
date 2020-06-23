package principle;

import java.math.BigDecimal;

public class Main {

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    public static void main(String[] args) {
        Car car = new Car();
        car.setPrice(new BigDecimal(1));
        Seller seller = new Seller();
        BigDecimal bigDecimal = seller.sellCar(car);
        BigDecimal bigDecimal1 = seller.sellAny(new Any() {
            public String getName() {
                return null;
            }

            public BigDecimal getPrice() {
                return null;
            }
        });
        Boss boss = new Boss();
        boss.read();
    }

}
