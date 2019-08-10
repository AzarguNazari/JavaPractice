package BasketMarket;

import java.io.Serializable;

public class Drink extends Item implements Serializable{
    private static final long serialVersionUID = 27L;
    public Drink(String name, String description, double price, int stock) {
        super(name, description, price, stock);
    }
}
