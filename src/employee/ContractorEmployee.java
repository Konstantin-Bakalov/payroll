package employee;

public class ContractorEmployee extends Employee {
    protected final int HOURS_THRESHOLD = 160;
    protected final double OVERTIME_RATE = 1.5;

    protected double hourlyRate;
    protected int hoursWorked;

    public ContractorEmployee(String name, double hourlyRate, int hoursWorked) {
        super(name);

        if (hourlyRate < 0) {
            throw new IllegalArgumentException("[warn] Negative hourly rate for %s".formatted(name));
        }

        if (hoursWorked < 0) {
            throw new IllegalArgumentException("[warn] Negative hours worked for %s".formatted(name));
        }

        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    @Override
    public double calculateGrossSalary() {
        var overtimeHours = calculateOvertimeHours();
        if (overtimeHours > 0) {
            return ((overtimeHours * OVERTIME_RATE) + (hoursWorked - overtimeHours)) * hourlyRate;
        }

        return hourlyRate * hoursWorked;
    }

    @Override
    public double calculateTax() {
        return 0;
    }

    protected int calculateOvertimeHours() {
        return Math.max(hoursWorked - HOURS_THRESHOLD, 0);
    }

    @Override
    public EmployeeType getEmployeeType() {
        return EmployeeType.CONTRACTOR;
    }
}
