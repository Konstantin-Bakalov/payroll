package employee;

public abstract class Employee {
    protected String name;

    public String getName() {
        return name;
    }

    public Employee(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("[warn] Employee name is missing");
        }

        this.name = name;
    }

    abstract public EmployeeType getEmployeeType();
}
