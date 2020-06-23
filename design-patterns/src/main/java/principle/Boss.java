package principle;

import lombok.Data;

@Data
public class Boss {

    private Seller seller;

    public void read() {
        seller.apply();
    }

}
