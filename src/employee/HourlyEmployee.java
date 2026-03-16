package employee;

public class HourlyEmployee extends ContractorEmployee {
    private final double taxRate;

    public HourlyEmployee(String name, double hourlyRate, int hoursWorked, double taxRate) {
        super(name, hourlyRate, hoursWorked);

        if (taxRate < 0) {
            throw new IllegalArgumentException("[warn] Negative tax rate for %s".formatted(name));
        }

        this.taxRate = taxRate;
    }

    @Override
    public double calculateTax() {
        return super.calculateGrossSalary() * taxRate;
    }

    @Override
    public EmployeeType getEmployeeType() {
        return EmployeeType.HOURLY;
    }
}
