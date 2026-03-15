package employee;

public class HourlyPayStrategy implements PayCalculationStrategy<HourlyEmployee> {
    private int calculateOvertimeHours(HourlyEmployee employee) {
        final int HOURS_THRESHOLD = 160;
        return Math.max(employee.getHoursWorked() - HOURS_THRESHOLD, 0);
    }

    @Override
    public double calculateGross(HourlyEmployee employee) {
        final double OVERTIME_RATE = 1.5;
        var overtimeHours = calculateOvertimeHours(employee);

        if (overtimeHours > 0) {
            return ((overtimeHours * OVERTIME_RATE) + (employee.getHoursWorked() - overtimeHours)) * employee.getHourlyRate();
        }

        return employee.getHourlyRate() * employee.getHoursWorked();
    }

    @Override
    public double calculateTax(HourlyEmployee employee) {
        return calculateGross(employee) * employee.getTaxRate();
    }
}
