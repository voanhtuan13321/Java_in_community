package bai13;

import bai13.model.Employee;
import bai13.model.Experience;
import bai13.model.Fresher;
import bai13.model.Intern;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * EmployeeManager class.
 *
 * @author AnhTuan
 * @version 1.0
 * @since 18/09/2023
 */
public class EmployeeManager {
  private final List<Employee> employees;

  public EmployeeManager() {
    this.employees = new ArrayList<>();
  }

  public void addEmployee(Employee employee) {
    employees.add(employee);
  }

  public void editEmployee(int employeeID, Employee updatedEmployee) {
    int size = employees.size();
    for (int i = 0; i < size; i++) {
      Employee employee = employees.get(i);
      if (employee.getID() == employeeID) {
        updatedEmployee.setID(employee.getID());
        employees.set(i, updatedEmployee);
        return;
      }
    }
  }

  public boolean removeEmployee(int employeeID) {
    Iterator<Employee> iterator = employees.iterator();
    while (iterator.hasNext()) {
      Employee employee = iterator.next();
      if (employee.getID() == employeeID) {
        iterator.remove();
        return true;
      }
    }
    return false;
  }

  public void showAllEmployees() {
    employees.forEach(Employee::showInfo);
  }

  public Employee findEmployeeByID(int employeeID) {
    for (Employee employee : employees) {
      if (employee.getID() == employeeID) {
        return employee; // Trả về nhân viên có ID tương ứng
      }
    }
    return null; // Trả về null nếu không tìm thấy
  }

  public List<Employee> findAllInterns() {
    return employees.stream()
        .filter(Intern.class::isInstance)
        .collect(Collectors.toList());
  }

  public List<Employee> findAllExperience() {
    return employees.stream()
        .filter(Experience.class::isInstance)
        .collect(Collectors.toList());
  }

  public List<Employee> findAllFresher() {
    return employees.stream()
        .filter(Fresher.class::isInstance)
        .collect(Collectors.toList());
  }
}
