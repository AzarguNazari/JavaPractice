package BasketMarket;

import java.io.Serializable;

public class Fruit extends Item implements Serializable{
    private static final long serialVersionUID = 26L;
    public Fruit(String name, String description, double price, int stock) {
        super(name, description, price, stock);
    }
}
