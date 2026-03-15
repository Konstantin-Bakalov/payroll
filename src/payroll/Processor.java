package payroll;

import employee.Employee;
import employee.StrategyFactory;

import java.util.Collection;

public interface Processor {
    Summary generatePayrollSummary(Collection<Employee> employees, StrategyFactory factory);
}
