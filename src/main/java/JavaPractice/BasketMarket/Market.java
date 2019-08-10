package BasketMarket;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Market implements Serializable{

    private static final long serialVersionUID = 25L; 
    private final String marketName;
    public List<Item> items = new ArrayList<>();
    private List<Customer> customers = new ArrayList<>();
    private Scanner input = new Scanner(System.in);
    private Pattern pattern;
    private Matcher matcher;
    private final Admin admin;

    // Constructor
    public Market(String marketName, int adminSSN, String adminFullName, String email, String pass) throws IOException, ClassNotFoundException {
        
        input = new Scanner(System.in); // setting the scanner
        
        this.marketName = marketName;   // setting the market name
        admin = new Admin(adminFullName, marketName, email, pass, adminSSN);
        
        // If the items and customers file doesn't exist, create new one
        File itemRecords = new File("item.txt"), customersRecords = new File("users.txt");
        if(!itemRecords.exists()) itemRecords.createNewFile();
        if(!customersRecords.exists()) customersRecords.createNewFile();
        
        // To load the items and customers records into List<Item> and List<Customer>

        try(ObjectInputStream users = new ObjectInputStream(new FileInputStream(customersRecords))){
            customers = (List<Customer>) users.readObject();
        }
        catch(EOFException ex){
        
        }
        
        try(ObjectInputStream allItems = new ObjectInputStream(new FileInputStream(itemRecords))){                     
            items = (List<Item>) allItems.readObject(); 
        }
        catch(EOFException ex){
        
        }
        
        
    }

    
    /**
     * This method is to register a new customer
     * @return 
     */
    public void registerCustomer(){
        Customer customer = (Customer) registerationForm();
        this.customers.add(customer);
        System.out.println("----- New Customer is added --- ");
        System.out.println(customer);
    }
    
    private Person registerationForm(){
        System.out.println("----------- User Register --------------");
        System.out.print("Enter Full Name: ");
        String name = input.nextLine();
        while (!testName.test(name)) {
            System.out.print("Wrong, Enter again your Full Name: ");
            name = input.nextLine();
        }
        System.out.print("Enter SSN (Social Security Number): ");
        int ssn = input.nextInt();
        while(isSSNexist(ssn)){
            System.out.println("Wrong, " + ssn + " is already existed in system");
            System.out.print("Enter SSN (Social Security Number): ");
            ssn = input.nextInt();
        }
        System.out.print("Enter Email address: ");
        String email = input.next();
        while (!testEmail.test(email) && isEmailExit(email)) {
            System.out.println("Wrong, The email is either wrong or already exists in system");
            System.out.print("Enter correct Email address: ");
            email = input.next();
        }
        System.out.print("Enter password: ");
        String password = input.next();
        while (!testPassword.test(password)) {
            System.out.print("Wrong, Enter again password[at least 6 characters]: ");
            password = input.next();
        }
        return new Person(name, email, password, ssn);
    }

    public void signin(){
        System.out.print("Enter your email: ");
        String email = input.next();
        System.out.print("Enter your password: ");
        String password = input.next();
        if(admin.getEmail().equalsIgnoreCase(email) && admin.getPassword().equalsIgnoreCase(password)){
            adminPanel();
        }
        else{
            Customer newCustomer = null;
            for(Customer c : customers) {
                if(c.getEmail().equalsIgnoreCase(email) && c.getPassword().equalsIgnoreCase(password)){
                    newCustomer = c; break;
                }
            }
                    
            if(newCustomer == null){
                System.out.println("Sorry, there's no such account registered");
            }
            else{
                System.out.println("----------------------------");
                customerPanel(newCustomer);
            }
        }
    }

    private boolean isEmailExit(String email){
        return customers.stream().anyMatch((c) -> (c.getEmail().equalsIgnoreCase(email)));
    }
    private boolean isSSNexist(int ssn){
        return customers.stream().anyMatch((c) -> (c.getSsn()== ssn));
    }
    
    /**
     * To Search the items
     *
     * @param item
     * @return
     */
    private List<Item> searchItems(String item) {
        List<Item> tempItems = this.items.stream().filter(i -> i.getName().contains(item)).collect(Collectors.toList());
        return tempItems;
    }

    public void printAllItems() throws FileNotFoundException, IOException, ClassNotFoundException {
        Map<Class, List<Item>> itemsCatagories = items.stream().collect(Collectors.groupingBy(x -> x.getClass()));
        this.items.stream().forEach(System.out::println);
    }

    public void adminPanel(){
        while (true) {
            System.out.println("Enter 1: Adding new Item");
            System.out.println("Enter 2: Removing Item");
            System.out.println("Enter 3: Increase Item Stock");
            System.out.println("Enter 4: Return Back");
            System.out.print("Enter your option: ");
            int option = input.nextInt();
            switch(option){
                case 1:
                    addNewItem();
                    break;
                case 2:
                    removeItem();
                    break;
                case 3:
                    incraseItemStock();
                    break;
                case 4:
                    return;
            }
        }
    }

    public Item findItem() {
        System.out.print("Enter item Name: ");
        String itemName = input.nextLine();
        List<Item> filteredList = items.stream().filter(x -> x.getName().contains(itemName)).collect(Collectors.toList());
        if(filteredList.size() > 0){
            for(int x = 0; x < filteredList.size(); x++){
                System.out.println("Enter " + x + ": to select " + filteredList.get(x));
            }
            System.out.print("Enter the number: ");
            int number = input.nextInt();
            while(number < 0 || number >= filteredList.size()){
                System.out.println("Wrong, Please enter the correct number");
                number = input.nextInt();
            }
            return filteredList.get(number);
        }
        else{
            System.out.println("Sorry, there is no such item");
            return null;
        }
    }

    private void addNewItem(){
        System.out.println("----------- New Item ---------");
        System.out.print("Enter 1: Add new Fruit");
        System.out.print("Enter 2: Add new Bakery");
        System.out.print("Enter 3: Add new Drink");
        System.out.print("Enter 4: Return Back");
        System.out.print("Enter option: ");
        int option = input.nextInt();
        while (option > 4 || option < 1) {
            System.out.println("ERROR: PLEASE ENTER CORRECT OPTION");
            System.out.println("----------- New Item ---------");
            System.out.print("Enter 1: Add new Fruit");
            System.out.print("Enter 2: Add new Bakery");
            System.out.print("Enter 3: Add new Drink");
            System.out.print("Enter 4: Exit");
            System.out.print("Enter option: ");
            option = input.nextInt();
        }
        System.out.print("Enter item name: ");
        String itemName = input.next();
        System.out.print("Enter item price: ");
        double price = input.nextDouble();
        System.out.print("Enter quantity: ");
        int quantity = input.nextInt();
        System.out.print("Write Description about " + itemName + ": ");
        String description = input.nextLine();
        Item temp = null;
        switch (option) {
            case 1:
                temp = new Fruit(itemName, description, price, quantity);
                break;
            case 2:
                temp = new Bakery(itemName, description, price, quantity);
                break;
            case 3:
                temp = new Drink(itemName, description, price, quantity);
                break;
        }
        items.add(temp);
        System.out.println("----- New Item Added -----");
        System.out.println(temp);
    }

    private void removeItem(){
        Item removeItem = findItem();
        if(removeItem != null && items.remove(removeItem)){
            System.out.println(removeItem + " is removed");
        }  
    }

    private void incraseItemStock(){
        Item selectItem = findItem();
        if(selectItem != null){
            System.out.print("How many stock crease?: ");
            int newStock = input.nextInt();
            selectItem.setQuantity(selectItem.getQuantity() + newStock);
            System.out.println(selectItem.getName() + "'s stock is incrased to " + selectItem.getQuantity());
        }
    }
    
    public void customerPanel(Customer customer){
        while(true){
            System.out.println("Enter 1: Purchase");
            System.out.println("Enter 2: Check Purchases History");
            System.out.println("Enter 3: Update Profile");
            System.out.println("Enter 4: Check Profile");
            System.out.println("Enter 5: Return Back");
            System.out.print("Enter Your Choice: ");
            int choice = input.nextInt();
            switch(choice){
                case 1:
                    customer.purchase(items);
                    return;
                case 2:
                    customer.purchaseFromHistory();
                    return;
                case 3:
                    customer.updateProfile();
                    return;
                case 4:
                    customer.checkProfile();
                    return;
                case 5: return;
            }
        }
        
    }

    public void shopping(Customer customer) throws IOException {
        while (true) {
            switch (menu()) {
                case 1:

                    break;

                case 2:

                    break;

                case 3:

                    break;

                case 4:
                    return;
            }
        }
    }

    private int menu() {
        System.out.println("Enter 1 for search");
        System.out.println("Enter 2 for adding new item");
        System.out.println("Enter 3 for purchasing item");
        System.out.println("Enter 4 for exit");
        System.out.print("Enter your option: ");
        int option = input.nextInt();
        while (option > 4 || option < 1) {
            System.out.println("Sorry, please enter a correct option");
            option = BasketApplication.input.nextInt();
        }
        return option;
    }


    public void searchItems(){
        System.out.println("--------------- Research Item -------------------");
        System.out.print("Enter item name: ");
        String item = input.next();
        List<Item> filteredItems = searchItems(item);
        if(filteredItems.isEmpty()){
            System.out.println("Sorry, " + item + " doesn't exist in database");
        }
        else{
            filteredItems.forEach(System.out::println);
        }
    }
    
    public void registeration(){
        Person p = registerationForm();
        Customer customer = new Customer(p.fullname, p.email, p.password, p.ssn);
        customers.add(customer);
        System.out.println("---------------- Successfully Registered ------------------");
        System.out.printf("%12s%s%n", "Name:", customer.fullname);
        System.out.printf("%12s%s%n", "Email:", customer.email);
        System.out.printf("%12s%s%n", "Password:", customer.password);
        System.out.printf("%12s%d%n", "SSN:", customer.ssn);
        System.out.println("-----------------------------------------------------------");
    }
    
    public void saveBackup() throws FileNotFoundException, IOException, IOException{
        try (ObjectOutputStream saveItems = new ObjectOutputStream(new FileOutputStream("item.txt"));ObjectOutputStream saveCustomers = new ObjectOutputStream(new FileOutputStream("customers.txt"))){
            saveCustomers.writeObject(customers);
            saveItems.writeObject(items);
        }
        System.out.println("Thank You for using " + this.marketName);
        System.out.println("All the data is backuped");
    }
    
    public void printAll(){
        customers.forEach(System.out::println);
        items.forEach(System.out::println);
    }
    
     /**
     * These are the utility predicates which are used during checking
     */
    // to test the name
    private Predicate<String> testName = name -> {
        pattern = Pattern.compile("[a-zA-Z]*\\w+");
        matcher = pattern.matcher(name);
        return matcher.find();
    };

    // to test the email address
    private final Predicate<String> testEmail = email -> {
        pattern = Pattern.compile("[\\w._]+@\\w+(.\\w+)+");
        matcher = pattern.matcher(email);
        return matcher.find();
    };

    // to test the password (6 words at least)
    private static final Predicate<String> testPassword = password -> password.length() >= 6;
}
