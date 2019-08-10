package Lab1.Interface2Lab;

public interface EmployeeDAO {

    public void add(Employee emp);

    public void update(Employee emp);

    public void delete(int id);

    public Employee findById(int id);

    public Employee[] getAllEmployees();
    
}