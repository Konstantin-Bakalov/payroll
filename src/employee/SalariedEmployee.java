package employee;

public class SalariedEmployee extends Employee {
    private final double FIXED_TAX_RATE = 0.2;
    private double monthlySalary;

    public SalariedEmployee(String name, double monthlySalary) {
        super(name);

        if (monthlySalary < 0) {
            throw new IllegalArgumentException("[warn] Negative monthly salary for %s".formatted(name));
        }

        this.monthlySalary = monthlySalary;
    }

    @Override
    public double calculateGrossSalary() {
        return monthlySalary;
    }

    @Override
    public double calculateTax() {
        return calculateGrossSalary() * FIXED_TAX_RATE;
    }

    @Override
    public EmployeeType getEmployeeType() {
        return EmployeeType.SALARIED;
    }
}
