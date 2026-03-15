package logging;

public interface Logger {
    public void logEmployeeAdded(String name);
    public void logPayrollStart(int employeeCount);
    public void logPayrollEnd(int employeeCount);
    public void logPayComputed(String name, double pay);
}
