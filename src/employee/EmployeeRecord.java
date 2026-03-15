package employee;

public record EmployeeRecord(String name, EmployeeType type, double grossSalary, double tax, double netSalary) {
}
