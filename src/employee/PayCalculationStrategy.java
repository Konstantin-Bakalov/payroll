package employee;

public interface PayCalculationStrategy {
    double calculateGross(Employee employee);
    double calculateTax(Employee employee);

    default double calculateNet(Employee employee) {
        return calculateGross(employee) - calculateTax(employee);
    }
}

/*
public interface PayCalculationStrategy<T extends Employee> {
    double calculateGross(T employee);
    double calculateTax(T employee);
    default double calculateNet(T employee) {
        return calculateGross(employee) - calculateTax(employee);
    }
}
 */