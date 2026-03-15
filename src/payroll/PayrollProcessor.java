package payroll;

import employee.Employee;
import employee.StrategyFactory;

import java.util.Collection;

public class PayrollProcessor implements  Processor {
    @Override
    public Summary generatePayrollSummary(Collection<Employee> employees, StrategyFactory factory) {
        var payrollSummary = new PayrollSummary(factory);

        for (Employee e : employees) {
            payrollSummary.addEmployee(e);
        }

        return payrollSummary;
    }
}
