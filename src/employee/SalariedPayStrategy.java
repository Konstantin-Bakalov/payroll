package employee;

public class SalariedPayStrategy implements PayCalculationStrategy<SalariedEmployee> {

    @Override
    public double calculateGross(SalariedEmployee employee) {
        return employee.getMonthlySalary();
    }

    @Override
    public double calculateTax(SalariedEmployee employee) {
        final double FIXED_TAX_RATE = 0.2;
        return employee.getMonthlySalary() * FIXED_TAX_RATE;
    }
}
