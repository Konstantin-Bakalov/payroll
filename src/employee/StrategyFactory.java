package employee;

public interface StrategyFactory {
//    <T extends Employee> PayCalculationStrategy<T> getStrategyForEmployee(T employee);
    PayCalculationStrategy getStrategyForEmployee(Employee employee);
}
