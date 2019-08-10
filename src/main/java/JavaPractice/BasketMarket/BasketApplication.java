package BasketMarket;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class BasketApplication{

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        
    	System.out.println("Hello");
    	
//        
//        System.out.println("------------ Welcome to E-Shopping Basket ------------");
//        Market market = new Market("E-Shopping Basket", 1414322, "Azargul Nazari", "admin@gmail.com", "jamshid");
//        
//        market.printAll();
//
//        topOuterLoop:
//        while(true){
//            switch(mainMenu()){
//                case 1:
//                    market.signin();
//                    break;
//                case 2:
//                    market.registeration();
//                    market.printAll();
//                    break;
//                case 3:
//                    market.searchItems();
//                    
//                    break;
//                case 4: 
//                    market.printAllItems();
//                    break;
//                case 5: break topOuterLoop;
//                default:
//                    System.out.println("Sorry, please enter a correct option");
//            }
//            
//        }
//
//        market.saveBackup();
        
    }
    
    private static int mainMenu(){
        System.out.println("---------------------");
        System.out.println("Enter 1: Sign In");
        System.out.println("Enter 2: Register");
        System.out.println("Enter 3: Search item");
        System.out.println("Enter 4: print all Items");
        System.out.println("Enter 5: Exit");
        System.out.print("Enter any option: ");
        return input.nextInt();
    }
    
    
    
}
