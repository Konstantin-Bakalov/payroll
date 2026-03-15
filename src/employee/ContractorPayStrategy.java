package employee;

public class ContractorPayStrategy implements PayCalculationStrategy<ContractorEmployee> {
    private int calculateOvertimeHours(ContractorEmployee employee) {
        final int HOURS_THRESHOLD = 160;
        return Math.max(employee.getHoursWorked() - HOURS_THRESHOLD, 0);
    }

    @Override
    public double calculateGross(ContractorEmployee employee) {
        final double OVERTIME_RATE = 1.5;
        var overtimeHours = calculateOvertimeHours(employee);

        if (overtimeHours > 0) {
            return ((overtimeHours * OVERTIME_RATE) + (employee.getHoursWorked() - overtimeHours)) * employee.getHourlyRate();
        }

        return employee.getHourlyRate() * employee.getHoursWorked();
    }

    @Override
    public double calculateTax(ContractorEmployee employee) {
        return 0;
    }
}
