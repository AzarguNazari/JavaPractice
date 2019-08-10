/*
 * In this practice, use the HashMap collection to count a list of part numbers. page 87
 */
package Lab3Collections;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author Azargul Nazari (1414322)
 */
public class Activity1ProductCounter {
    
    private Map<String, Long>   partNumber = new HashMap<>();
    private Map<String, String> description = new TreeMap<>();
    
    public Activity1ProductCounter(Map<String, String> map){
        description = map;
    }
    
    public static void main(String[] args) {
        
        // List of part data
        String[] parts = new String[]{"1S01", "1S01", "1S01", "1S01", "1S01", "1S02", "1S02", "1S02", "1H01", "1H01", "1S02", "1S01", "1S01", "1H01", "1H01", "1H01", "1S02", "1S02", "1M02", "1M02", "1M02"};
        
        Map<String, String> products = new TreeMap<>();
        products.put("Blue Polo Shirt", "1S01");
        products.put("Black Polo Shirt", "1S02");
        products.put("Red Ball Cap", "1H01");
        products.put("Duke Mug", "1M02");
        
        Activity1ProductCounter act = new Activity1ProductCounter(products);
        act.processList(parts);
        act.printReport();
    }
    
    /**
     * This method is to count the number of every unique parts
     * @param list contains all the parts
     */
    public void processList(String[] list){ 
        long count = 0;
        for(String s: list){
            if(partNumber.containsKey(s)){
               count = partNumber.get(s);
               count++;
               partNumber.put(s, new Long(count));
            }
            else{
                partNumber.put(s, new Long(1));
            }
        }
    }
    
    /**
     * This method is to print all the products in sorted way according to its description
     */
    public void printReport(){ 
        System.out.println("=== Product Report ===");
        for(String names: description.keySet()){
            System.out.print("Name: " + names);
            System.out.println("\t\tCount: " + partNumber.get(description.get(names)));
        }
    }
}
