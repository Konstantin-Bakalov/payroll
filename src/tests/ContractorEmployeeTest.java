package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import employee.ContractorEmployee;
import employee.EmployeeType;
import org.junit.jupiter.api.Test;

public class ContractorEmployeeTest {
    @Test
    void testContractorEmployeeNegHourlyRate() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new ContractorEmployee("Alice", -5, 200),
                "Creating a ContractorEmployee with negative hourly rate should throw");
    }

    @Test
    void testContractorEmployeeNegHoursWorked() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new ContractorEmployee("Alice", 50, -20),
                "Creating a SalariedEmployee with negative hours worked should throw");
    }

    @Test
    void testContractorEmployeeType() {
        var employee = new ContractorEmployee("Alice", 200, 250);
        assertEquals(EmployeeType.CONTRACTOR, employee.getEmployeeType());
    }

    @Test
    void testCalculateGrossSalaryNoOvertime() {
        var employee = new ContractorEmployee("Alice", 150, 160);
        var gross = employee.calculateGrossSalary();
        assertEquals(24_000, gross);
    }

    @Test
    void testCalculateGrossSalaryWithOvertime() {
        var employee = new ContractorEmployee("Alice", 150, 190);
        var gross = employee.calculateGrossSalary();
        assertEquals(30750, gross);
    }

    @Test
    void testCalculateTax() {
        var employee = new ContractorEmployee("Alice", 200, 140);
        var tax = employee.calculateTax();
        assertEquals(0, tax);
    }

    @Test
    void testCalculateNetSalaryNoOvertime() {
        var employee = new ContractorEmployee("Alice", 200, 140);
        assertEquals(28_000, employee.calculateNetSalary());
    }

    @Test
    void testCalculateNetSalaryWithOvertime() {
        var employee = new ContractorEmployee("Alice", 200, 170);
        assertEquals(35_000, employee.calculateNetSalary());
    }
}
