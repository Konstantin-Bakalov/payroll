package payroll;

import logging.Logger;

public class PayrollLogger {
    private final Logger logger;

    public PayrollLogger(Logger logger) {
        this.logger = logger;
    }

    public void log(Summary payrollSummary) {
        logger.logPayrollStart(payrollSummary.getAllEmployeeCount());

        for (var record : payrollSummary.getEmployeeRecords()) {
            logger.logEmployeeAdded(record.name());
            logger.logPayComputed(record.name(), record.netSalary());
        }

        logger.logPayrollEnd(payrollSummary.getAllEmployeeCount());
    }
}
