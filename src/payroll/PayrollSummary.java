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

    private void updateTotalCosts(double gross, double tax, double net) {
        totalGross += gross;
        totalTax += tax;
        totalNet += net;
    }

    @Override
    public void addEmployee(Employee e) {
        employeeCount.merge(e.getEmployeeType(), 1, Integer::sum);

        var gross = e.calculateGrossSalary();
        var tax = e.calculateTax();
        var net = e.calculateNetSalary();

        updateTotalCosts(gross, tax, net);
        records.add(new EmployeeRecord(e.getName(), e.getEmployeeType(), gross, tax, net));
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
