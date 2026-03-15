package payroll;

import employee.Employee;
import employee.EmployeeRecord;
import employee.EmployeeType;

import java.util.List;

public interface Summary {
    void addEmployee(Employee e);
    List<EmployeeRecord> getEmployeeRecords();
    int getEmployeeCount(EmployeeType type);
    int getAllEmployeeCount();
    double getTotalGross();
    double getTotalTax();
    double getTotalNet();
}
