package Lesson2;

import java.util.ArrayList;

public interface EmployeeDAO {
    void add(Employee employee);
    void remove(Employee employee);
    void update(Employee employee);
    Employee findByID(int id);
    ArrayList<Employee> getEmployees();
}
