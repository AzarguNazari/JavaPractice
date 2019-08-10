package BasketMarket;


public class Admin extends Person{

    public Admin(String fullname, String username, String email, String password, int ssn) {
        super(fullname, email, password, ssn);
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
   
}
