package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import employee.*;
import org.junit.jupiter.api.Test;
import payroll.PayrollSummary;

public class PayrollSummaryTest {
    private Employee alice = new SalariedEmployee("Alice", 500);
    private Employee bob = new HourlyEmployee("Bob", 50, 70, 0.35);
    private Employee ciara = new ContractorEmployee("Ciara", 50, 170);

    @Test
    void testAddEmployeeCount() {
        var summary = new PayrollSummary();
        summary.addEmployee(alice);
        summary.addEmployee(bob);
        summary.addEmployee(ciara);

        assertEquals(1, summary.getEmployeeCount(EmployeeType.SALARIED));
        assertEquals(1, summary.getEmployeeCount(EmployeeType.HOURLY));
        assertEquals(1, summary.getEmployeeCount(EmployeeType.CONTRACTOR));
        assertEquals(3, summary.getAllEmployeeCount());
    }

    @Test
    void testSummaryTotal() {
        var summary = new PayrollSummary();
        summary.addEmployee(alice);
        summary.addEmployee(bob);
        summary.addEmployee(ciara);

        var totalGross = alice.calculateGrossSalary() + bob.calculateGrossSalary() + ciara.calculateGrossSalary();
        var totalTax = alice.calculateTax() + bob.calculateTax() + ciara.calculateTax();
        var totalNet = alice.calculateNetSalary() + bob.calculateNetSalary() + ciara.calculateNetSalary();

        assertEquals(totalGross, summary.getTotalGross(), 1e-9);
        assertEquals(totalTax, summary.getTotalTax(), 1e-9);
        assertEquals(totalNet, summary.getTotalNet(), 1e-9);
    }

    @Test
    void testZeroEmployeesInSummary() {
        var summary = new PayrollSummary();

        assertEquals(0, summary.getAllEmployeeCount());
        assertEquals(0, summary.getTotalGross());
        assertEquals(0, summary.getTotalTax());
        assertEquals(0, summary.getTotalNet());
    }

    @Test
    void testOneEmployeeInSummary() {
        var summary = new PayrollSummary();
        summary.addEmployee(alice);

        assertEquals(alice.getName(), summary.getEmployeeRecords().getFirst().name());
        assertEquals(alice.getEmployeeType(), summary.getEmployeeRecords().getFirst().type());
        assertEquals(alice.calculateGrossSalary(), summary.getTotalGross());
        assertEquals(alice.calculateTax(), summary.getTotalTax());
        assertEquals(alice.calculateNetSalary(), summary.getTotalNet());
    }
}
