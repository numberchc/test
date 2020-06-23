package principle;


import lombok.Data;

import java.math.BigDecimal;

@Data
public class Seller implements Dance, Sing {

    /**
     * 开闭原则
     */
    public BigDecimal sellCar(Car car) {
        return car.getPrice();
    }

    /**
     * 依赖倒置原则
     */
    public BigDecimal sellAny(Any any) {
        return any.getPrice();
    }

    /**
     * 单一职责原则
     */
    public void dance() {
        System.out.println("dance...");
    }

    public void sing() {
        System.out.println("sing...");
    }

    /**
     * 迪米特法则
     */
    public void apply(Report report) {
        report.show();
    }

    private Report report;

    public void apply() {
        report.show();
    }

}


