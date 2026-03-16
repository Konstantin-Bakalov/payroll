package payroll;

import employee.Employee;

import java.util.Collection;

public class PayrollProcessor implements  Processor {
    @Override
    public Summary generatePayrollSummary(Collection<Employee> employees) {
        var payrollSummary = new PayrollSummary();

        for (Employee e : employees) {
            payrollSummary.addEmployee(e);
        }

        return payrollSummary;
    }
}
