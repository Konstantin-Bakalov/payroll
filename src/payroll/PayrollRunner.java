package payroll;

import employee.Employee;
import logging.Logger;

import java.util.Collection;

public class PayrollRunner {
    private final Processor processor;
    private final Logger logger;

    public PayrollRunner(Processor processor, Logger logger) {
        this.processor = processor;
        this.logger = logger;
    }

    public Summary run(Collection<Employee> employees) {
        logger.logPayrollStart(employees.size());

        var payrollSummary = processor.generatePayrollSummary(employees);

        for (var record : payrollSummary.getEmployeeRecords()) {
            logger.logEmployeeAdded(record.name());
            logger.logPayComputed(record.name(), record.netSalary());
        }

        logger.logPayrollEnd(payrollSummary.getAllEmployeeCount());

        return payrollSummary;
    }
}
