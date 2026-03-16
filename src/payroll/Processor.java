package payroll;

import employee.Employee;

import java.util.Collection;

public interface Processor {
    Summary generatePayrollSummary(Collection<Employee> employees);
}
