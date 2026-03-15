import employee.Employee;
import employee.ContractorEmployee;
import employee.HourlyEmployee;
import employee.SalariedEmployee;
import formatting.CurrencyFormatter;
import logging.AuditLogger;
import payroll.PayrollProcessor;
import payroll.PayrollRunner;
import payroll.PayrollSummaryPrinter;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new SalariedEmployee("Alice", 5000));
        employees.add(new SalariedEmployee("Alice", 5000));
        employees.add(new HourlyEmployee("Bob", 50, 80, 0.35));
        employees.add(new ContractorEmployee("Charlie", 60, 0));

        var currencyFormatter = new CurrencyFormatter();
        var logger = new AuditLogger(System.out::println, currencyFormatter);
        var processor = new PayrollProcessor();
        var summary = new PayrollRunner(processor, logger).run(employees);
        var summaryPrinter = new PayrollSummaryPrinter(System.out::println, currencyFormatter);

        summaryPrinter.print(summary);
    }
}