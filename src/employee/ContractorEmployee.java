package employee;

public class ContractorEmployee extends Employee {
    private final double hourlyRate;
    private final int hoursWorked;

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

    public double getHourlyRate() {
       return hourlyRate;
    }

    public int getHoursWorked() {
        return hoursWorked;
    }

    @Override
    public EmployeeType getEmployeeType() {
        return EmployeeType.CONTRACTOR;
    }
}
