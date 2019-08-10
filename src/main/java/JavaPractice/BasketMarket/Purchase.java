package BasketMarket;


import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class Purchase implements Serializable{
    private static final long serialVersionUID = 30L;
    private final ArrayList<Item> items;
    private final LocalDate purchaseDate;
    
    public Purchase(){
        items = new ArrayList<>();
        purchaseDate = LocalDate.now();
    }
    
    public void addItem(Item item){
        items.add(item);
    }
    
    public void invoice(){
        double total = 0;
        total = items.stream().map((i) -> {
            System.out.print(i);
            return i;
        }).map((i) -> i.getPrice()).reduce(total, (accumulator, _item) -> accumulator + _item);
        System.out.println("Total : " + total);
    }
    
    public ArrayList<Item> getItems(){
        return (ArrayList<Item>) items.clone();
    }
    
    @Override
    public String toString(){
        StringBuilder temp = new StringBuilder();
        temp.append("--- Purchase on ").append(this.purchaseDate).append("\n");
        items.forEach(p -> temp.append(p));
        return temp.toString();
    }
}
