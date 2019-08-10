package BasketMarket;


import java.io.Serializable;
import java.util.List;

public class Customer extends Person implements Serializable{

    private static final long serialVersionUID = 24L;
    private List<Purchase> purchases;

    public Customer(String fullname, String email, String password, int ssn) {
        super(fullname, email, password, ssn);
    }

    public List<Purchase> getPurchases() {
        return purchases;
    }

    public String getFullname() {
        return fullname;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public int getSsn() {
        return ssn;
    }

    public void setPurchases(List<Purchase> purchases) {
        this.purchases = purchases;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }


    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setSsn(int ssn) {
        this.ssn = ssn;
    }
    
    public boolean order(Purchase item){
        return true;
    }

    public void displayHistory(){
        
    }
    
    @Override
    public String toString(){
        return "{Name: " + super.fullname + ", SSN: " + super.ssn + ", Email: " + super.email + ", " + super.password + "}\n";
    }
    
    public void purchase(List<Item> items){
        
    }
    
    public void purchaseFromHistory(){
    
    }
    
    public void updateProfile(){
    
    }
    
    public void checkProfile(){
    
    }
    
    public void purchaseHistory(){
        System.out.println("-------- Purchase History --------");
        purchases.forEach(System.out::println);
    }
    
}
