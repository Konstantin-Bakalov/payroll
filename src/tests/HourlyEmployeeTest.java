package tests;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

import employee.EmployeeType;
import employee.HourlyEmployee;
import org.junit.jupiter.api.Test;

public class HourlyEmployeeTest {
    @Test
    void testHourlyEmployeeNullName() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new HourlyEmployee("Alice", 25, 300, -1.3),
                "Creating an HourlyEmployee with negative tax rate should throw");
    }

    @Test
    void testHourlyEmployeeType() {
        var employee = new HourlyEmployee("Alice", 5000, 20, 0.3);
        assertEquals(EmployeeType.HOURLY, employee.getEmployeeType());
    }

    @Test
    void testCalculateGrossSalaryNoOvertime() {
        var employee = new HourlyEmployee("Alice", 40, 70, 0.25);
        var gross = employee.calculateGrossSalary();
        assertEquals(2800.0, gross);
    }

    @Test
    void testCalculateGrossSalaryWithOvertime() {
        var employee = new HourlyEmployee("Alice", 40, 180, 0.25);
        var gross = employee.calculateGrossSalary();
        assertEquals(7600.0, gross);
    }

    @Test
    void testCalculateTaxNoOvertime() {
        var employee = new HourlyEmployee("Alice", 40, 100, 0.25);
        var tax = employee.calculateTax();
        assertEquals(1000, tax);
    }

    @Test
    void testCalculateTaxWithOvertime() {
        var employee = new HourlyEmployee("Alice", 40, 200, 0.25);
        var tax = employee.calculateTax();
        assertEquals(2200, tax);
    }

    @Test
    void testCalculateNetWithOvertime() {
        var employee = new HourlyEmployee("Alice", 40, 200, 0.25);
        var net = employee.calculateNetSalary();
        assertEquals(6600, net);
    }

    @Test
    void testCalculateNetNoOvertime() {
        var employee = new HourlyEmployee("Alice", 40, 100, 0.35);
        var net = employee.calculateNetSalary();
        assertEquals(2600, net);
    }
}
