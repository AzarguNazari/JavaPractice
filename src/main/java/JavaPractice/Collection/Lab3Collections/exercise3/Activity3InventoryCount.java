package Lab3Collections.exercise3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Azargul Nazari
 */
public class Activity3InventoryCount {
    
    public static void main(String[] args) {
        
        // Current Shirt type for a transaction
        Shirt currentShirt = null;

        // Create Items to Count
        Map<String, Shirt> polos = new HashMap<>(10);
        polos.put("P001", new Shirt("P001", "Blue Polo Shirt", "Blue", "L"));
        polos.put("P002", new Shirt("P002", "Black Polo Shirt", "Black", "M"));
        polos.put("P003", new Shirt("P003", "Maroon Polo Shirt", "Maroon", "XL"));
        polos.put("P004", new Shirt("P004", "Tan Polo Shirt", "Tan", "S"));
        
        // Transactions
        List<DukeTransaction> transactions = new ArrayList<>(20);
        transactions.add(DukeTransaction.createTransaction("P001", "Purchase", 30));
        transactions.add(DukeTransaction.createTransaction("P002", "Purchase", 20));
        transactions.add(DukeTransaction.createTransaction("P003", "Purchase", 20));
        transactions.add(DukeTransaction.createTransaction("P004", "Purchase", 20));
        transactions.add(DukeTransaction.createTransaction("P001", "Sale", 1));
        transactions.add(DukeTransaction.createTransaction("P001", "Sale", 2));
        transactions.add(DukeTransaction.createTransaction("P002", "Sale", 5));
        transactions.add(DukeTransaction.createTransaction("P002", "Sale", 1));
        transactions.add(DukeTransaction.createTransaction("P002", "Sale", 2));
        transactions.add(DukeTransaction.createTransaction("P002", "Sale", 2));
        transactions.add(DukeTransaction.createTransaction("P002", "Purchase", 5));
        transactions.add(DukeTransaction.createTransaction("P001", "Sale", 3));
        transactions.add(DukeTransaction.createTransaction("P003", "Sale", 2));
        transactions.add(DukeTransaction.createTransaction("P003", "Purchase", 5));
        transactions.add(DukeTransaction.createTransaction("P003", "Sale", 3));
        transactions.add(DukeTransaction.createTransaction("P004", "Sale", 2));
        transactions.add(DukeTransaction.createTransaction("P004", "Purchase", 5));
        transactions.add(DukeTransaction.createTransaction("P004", "Sale", 4));
        
        // Count the shirts
        for (DukeTransaction transaction : transactions) {
            if (polos.containsKey(transaction.getProductID())) {
                currentShirt = polos.get(transaction.getProductID());
            } else {
                System.out.println("Error: Invalid part number");
            }

            switch (transaction.getTransactionType()) {
                case "Purchase":
                    currentShirt.addItems(transaction.getCount());
                    break;

                case "Sale":
                    currentShirt.removeItems(transaction.getCount());
                    break;

                default:
                    System.out.println("Error: Invalid Transaction Type");
                    continue;
            }

        }

        // Convert to List
        List<Shirt> poloList = new ArrayList<>(polos.values());

        // Init Comparators
        Comparator<Shirt> sortDescription = new SortShirtByDesc();
        Comparator<Shirt> sortCount = new SortShirtByCount();

        // Print Results - Sort by Description
        Collections.sort(poloList, sortDescription);
        System.out.println("=== Inventory Report - Description ===");

        for (Shirt shirt : poloList) {
            System.out.println(shirt.toString());
        }

        // Print Results - Sort by Count
        Collections.sort(poloList, sortCount);
        System.out.println("=== Inventory Report - Count ===");

        for (Shirt shirt : poloList) {
            System.out.println(shirt.toString());
        }
    }
    
}

class Shirt implements InventoryCount {
    private String id = "";
    private String description = "";
    private String color = "";
    private String size = "";
    private long count = 0;

    private Shirt() {
    }

    public Shirt(String id, String description, String color, String size) {
        this.id = id;
        this.description = description;
        this.color = color;
        this.size = size;
    }

    public String getId() {
        return this.id;
    }

    public String getDescription() {
        return description;
    }

    public String getColor() {
        return color;
    }

    public String getSize() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(256);
        sb.append("Shirt ID: ").append(this.getId()).append("\n");
        sb.append("Description: ").append(this.getDescription()).append("\n");
        sb.append("Color: ").append(this.getColor()).append("\n");
        sb.append("Size: ").append(this.getSize()).append("\n");
        sb.append("Inventory: ").append(this.getCount()).append("\n");
        
        return sb.toString();
    }

    @Override
    public long getCount() {
        return count;
    }

    @Override
    public void addItems(long count) {
        this.count = this.count + count;
    }

    @Override
    public void removeItems(long count) {
        if ((this.count - count) > 0) {
            this.count = this.count - count;
        } else {
            System.out.println("Negative inventory number error.");
        }
    }
    
}


// sort the shirts by the count number
class SortShirtByCount implements Comparator<Shirt>{

    @Override
    public int compare(Shirt o1, Shirt o2) {
        Long c1 = new Long(o1.getCount());
        Long c2 = new Long(o2.getCount());
        return c1.compareTo(c2);
    }

}


// Sort the shirt according the the description
class SortShirtByDesc implements Comparator<Shirt>{

    @Override
    public int compare(Shirt o1, Shirt o2) {
        return o1.getDescription().compareTo(o2.getDescription());
    }

}

interface InventoryCount {

    public long getCount();

    public void addItems(long count);

    public void removeItems(long count);
}

class DukeTransaction {
    private String productID = "";
    private String transactionType = "";
    private long count = 0;
    private DukeTransaction(String productID, String transactionType, long count) {
        this.productID = productID;
        this.transactionType = transactionType;
        this.count = count;
    }
    private DukeTransaction(){
    
    }
    public static DukeTransaction createTransaction(String productID, String transactionType, long count) {
        DukeTransaction newTransaction = new DukeTransaction(productID, transactionType,
                count);
        return newTransaction;
    }
    public String getProductID() {
        return this.productID;
    }

    public String getTransactionType() {
        return this.transactionType;
    }

    public long getCount() {
        return this.count;
    }
}