package BasketMarket;


import java.io.Serializable;


public class Person implements Serializable{
    private static final long serialVersionUID = 29L;
    protected String fullname, email, password;
    protected int ssn;

    public Person(){}

    public Person(String fullname, String email, String password, int ssn) {
        this.fullname = fullname;
        this.email = email;
        this.password = password;
        this.ssn = ssn;
    }
}


