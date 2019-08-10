package Lesson2;

import java.util.Date;
import java.util.Objects;

public class Employee {

    private String fName, lName;
    private Date startWork;
    private int age, id;
    private double salary;

    public Employee(int id, String fName, String lName, Date startWork, int age, double salary) {
        this.id = id;
        this.fName = fName;
        this.lName = lName;
        this.startWork = startWork;
        this.age = age;
        this.salary = salary;
    }
    
    @Override
    public boolean equals(Object o) {
        boolean result = false;
        if ((o != null) && (o instanceof firstProject.Employee)) {
            firstProject.Employee e = (firstProject.Employee) o;
            if ((e.getID() == this.id)
                    && (e.getFname().equals(this.fName))
                    && (e.getlName().equals(this.lName))
                    && (e.getAge() == this.age)
                    && (e.getSalary() == this.salary)) {
                result = true;
            }
        }
        return result;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.fName);
        hash = 59 * hash + Objects.hashCode(this.lName);
        hash = 59 * hash + this.age;
        hash = 59 * hash + this.id;
        hash = 59 * hash + (int) (Double.doubleToLongBits(this.salary) ^ (Double.doubleToLongBits(this.salary) >>> 32));
        return hash;
    }
    
    
    public int getID(){
        return id;
    }
    
    public String getFname() {
        return fName;
    }

    public String getlName() {
        return lName;
    }

    public Date getStartWork() {
        return startWork;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }

    public void setID(int id){
        this.id = id;
    }
    
    public void setFname(String fName) {
        this.fName = fName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public void setStartWork(Date startWork) {
        this.startWork = startWork;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
