package principle;

import lombok.Data;

import java.math.BigDecimal;

/**
 * 开闭原则
 */
@Data
public class DiscountCar extends Car {

    private BigDecimal price;

    private BigDecimal discount;

    @Override
    public BigDecimal getPrice() {
        return price.multiply(discount);
    }

}
