package tests;

import employee.EmployeeType;
import employee.SalariedEmployee;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class SalariedEmployeeTest {
    @Test
    void testSalariedEmployeeNullName() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new SalariedEmployee(null, 0),
                "Creating a SalariedEmployee with null name should throw");
    }

    @Test
    void testSalariedEmployeeNegativeSalary() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new SalariedEmployee("SalariedEmployee", -20),
                "Creating a SalariedEmployee with negative salary should throw");
    }

    @Test
    void testSalariedEmployeeType() {
        var employee = new SalariedEmployee("SalariedEmployee", 5000);
        assertEquals(EmployeeType.SALARIED, employee.getEmployeeType());
    }

    @Test
    void testCalculateGrossSalary() {
        var employee = new SalariedEmployee("SalariedEmployee", 5000);
        var gross = employee.calculateGrossSalary();
        assertEquals(5000, gross);
    }

    @Test
    void testCalculateTax() {
        var employee = new SalariedEmployee("SalariedEmployee", 5000);
        var tax = employee.calculateTax();
        assertEquals(1000, tax);
    }

    @Test
    void testCalculateZeroTax() {
        var employee = new SalariedEmployee("SalariedEmployee", 0);
        var tax = employee.calculateTax();
        assertEquals(0, tax);
    }

    @Test
    void testCalculateMaxTax() {
        var employee = new SalariedEmployee("SalariedEmployee", Double.MAX_VALUE);
        var tax = employee.calculateTax();
        assertEquals(employee.calculateGrossSalary() * employee.getTaxRate(), tax);
    }
}
