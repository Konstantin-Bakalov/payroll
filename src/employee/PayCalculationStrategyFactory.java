package employee;

public class PayCalculationStrategyFactory implements StrategyFactory {
    @Override
    public PayCalculationStrategy getStrategyForEmployee(Employee employee) {
        return switch(employee.getEmployeeType()) {
            case SALARIED -> new SalariedPayStrategy();
            case CONTRACTOR -> new ContractorPayStrategy();
            case HOURLY -> new HourlyPayStrategy();
        };
    }

    /*
    @Override
    public PayCalculationStrategy<? extends Employee> getStrategyForEmployee(Employee employee) {
        return switch(employee.getEmployeeType()) {
            case SALARIED -> new SalariedPayStrategy();
            case CONTRACTOR -> new ContractorPayStrategy();
            case HOURLY -> new HourlyPayStrategy();
        };
    }
     */
}
