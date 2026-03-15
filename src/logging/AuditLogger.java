package logging;

import employee.Employee;
import formatting.CurrencyFormatterInterface;
import payroll.Summary;

import java.util.function.Consumer;

public class AuditLogger implements AuditLoggerInterface {
    private final Consumer<String> consumer;
    private final CurrencyFormatterInterface formatter;

    public AuditLogger(Consumer<String> consumer, CurrencyFormatterInterface formatter) {
        this.consumer = consumer;
        this.formatter = formatter;
    }

    @Override
    public void logEmployeeAdded(Employee employee) {
        consumer.accept("[audit] Employee added %s".formatted(employee.getName()));
    }

    @Override
    public void logPayrollStart(int employeeCount) {
        consumer.accept("[audit] Payroll run started for %d employees".formatted(employeeCount));
    }

    @Override
    public void logPayrollEnd(Summary summary) {
        consumer.accept("[audit] Payroll run finished: %d employees processed".formatted(summary.getAllEmployeeCount()));
    }

    @Override
    public void logPayComputed(Employee employee) {
        consumer.accept("[audit] Pay computer for %s : %s".formatted(employee.getName(), formatter.format(employee.calculateNetSalary())));
    }
}
