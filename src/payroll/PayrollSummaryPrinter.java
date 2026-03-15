package payroll;

import employee.EmployeeType;
import formatting.Formatter;

import java.util.function.Consumer;

public class PayrollSummaryPrinter {
    private final Consumer<String> consumer;
    private final Formatter formatter;

    public PayrollSummaryPrinter(Consumer<String> consumer, Formatter formatter) {
        this.consumer = consumer;
        this.formatter = formatter;
    }

    public void print(Summary summary) {
        var builder = new StringBuilder();

        for (EmployeeType type : EmployeeType.values()) {
            builder
                    .append(type.name().toLowerCase())
                    .append(" count: ")
                    .append(summary.getEmployeeCount(type))
                    .append("\n");
        }

        consumer.accept("""
                Payroll summary:
                %s
                total gross: %s
                total tax: %s
                total net: %s
                """.formatted(builder,
                        formatter.format(summary.getTotalGross()),
                        formatter.format(summary.getTotalTax()),
                        formatter.format(summary.getTotalNet()))
                .indent(4));
    }
}