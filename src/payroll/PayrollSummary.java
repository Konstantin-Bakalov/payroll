package payroll;

import employee.Employee;
import employee.EmployeeRecord;
import employee.EmployeeType;

import java.util.*;

public class PayrollSummary implements Summary {
    private double totalGross = 0;
    private double totalTax = 0;
    private double totalNet = 0;

    private final List<EmployeeRecord> records = new ArrayList<>();
    private final Map<EmployeeType, Integer> employeeCount = new EnumMap<>(EmployeeType.class);

    private void updateTotalCosts(Employee e) {
        totalGross += e.calculateGrossSalary();
        totalTax += e.calculateTax();
        totalNet += e.calculateNetSalary();
    }

    @Override
    public void addEmployee(Employee e) {
        updateTotalCosts(e);
        employeeCount.merge(e.getEmployeeType(), 1, Integer::sum);
        records.add(new EmployeeRecord(e.getName(), e.getEmployeeType(), e.calculateGrossSalary(), e.calculateTax(), e.calculateNetSalary()));
    }

    @Override
    public List<EmployeeRecord> getEmployeeRecords() {
        return records;
    }

    @Override
    public int getEmployeeCount(EmployeeType type) {
        return employeeCount.getOrDefault(type, 0);
    }

    @Override
    public int getAllEmployeeCount() {
        return records.size();
    }

    @Override
    public double getTotalGross() {
        return totalGross;
    }

    @Override
    public double getTotalTax() {
        return totalTax;
    }

    @Override
    public double getTotalNet() {
        return totalNet;
    }
}
