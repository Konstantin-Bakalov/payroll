package payroll;

import employee.Employee;
import logging.AuditLoggerInterface;
import payroll.Summary;

import java.util.Collection;

public class PayrollProcessor {
    private final AuditLoggerInterface logger;

    public PayrollProcessor(AuditLoggerInterface logger) {
        this.logger = logger;
    }

    public Summary generatePayrollSummary(Collection<Employee> employees) {
        var payrollSummary = new PayrollSummary();
        logger.logPayrollStart(employees.size());

        for (Employee e : employees) {
            payrollSummary.addEmployee(e);
            logger.logEmployeeAdded(e);
            logger.logPayComputed(e);
        }

        logger.logPayrollEnd(payrollSummary);

        return payrollSummary;
    }
}
