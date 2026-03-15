package logging;

import employee.Employee;
import payroll.Summary;

public interface AuditLoggerInterface {
    public void logEmployeeAdded(Employee employee);
    public void logPayrollStart(int employeeCount);
    public void logPayrollEnd(Summary summary);
    public void logPayComputed(Employee employee);
}
