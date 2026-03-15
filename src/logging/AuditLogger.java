package logging;

import formatting.Formatter;

import java.util.function.Consumer;

public class AuditLogger implements Logger {
    private final Consumer<String> consumer;
    private final Formatter formatter;

    public AuditLogger(Consumer<String> consumer, Formatter formatter) {
        this.consumer = consumer;
        this.formatter = formatter;
    }

    @Override
    public void logEmployeeAdded(String name) {
        consumer.accept("[audit] Employee added %s".formatted(name));
    }

    @Override
    public void logPayrollStart(int employeeCount) {
        consumer.accept("[audit] Payroll run started for %d employees".formatted(employeeCount));
    }

    @Override
    public void logPayrollEnd(int employeeCount) {
        consumer.accept("[audit] Payroll run finished: %d employees processed".formatted(employeeCount));
    }

    @Override
    public void logPayComputed(String name, double pay) {
        consumer.accept("[audit] Pay computer for %s : %s".formatted(name, formatter.format(pay)));
    }
}
