package BasketMarket;


import java.io.Serializable;
import java.util.Objects;

public class Item implements Serializable, Comparable<Item>{
    
    private static final long serialVersionUID = 23L;
    protected  String name;
    protected double price;
    protected int quantity;
    protected String description;

    public Item(String name, String description, double price, int quantity) {
        this.description = description;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }


    @Override
    public boolean equals(Object o1) {
        return this.hashCode() == ((Item) o1).hashCode();
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.name);
        hash = 59 * hash + (int) (Double.doubleToLongBits(this.price) ^ (Double.doubleToLongBits(this.price) >>> 32));
        hash = 59 * hash + this.quantity;
        hash = 59 * hash + Objects.hashCode(this.description);
        return hash;
    }

    @Override
    public String toString() {
        return "Item Name: " + name + "\nDescription: " + description + "\nPrice: " + price + "\nQuantity: " + quantity + "\n-------------------------------";
    }

    @Override
    public int compareTo(Item o) {
        return (this.getPrice() < o.getPrice())? -1 : (this.getPrice() > o.getPrice())? 1: 0;
    }
}
