package employee;

public class HourlyEmployee extends Employee {
    private final double hourlyRate;
    private final int hoursWorked;
    private final double taxRate;

    public HourlyEmployee(String name, double hourlyRate, int hoursWorked, double taxRate) {
        super(name);

        if (taxRate < 0) {
            throw new IllegalArgumentException("[warn] Negative tax rate for %s".formatted(name));
        }

        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
        this.taxRate = taxRate;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public int getHoursWorked() {
        return hoursWorked;
    }

    public double getTaxRate() {
        return taxRate;
    }

    @Override
    public EmployeeType getEmployeeType() {
        return EmployeeType.HOURLY;
    }
}
