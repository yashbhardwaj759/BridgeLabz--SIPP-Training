public class Employee {
    public String employeeID;
    protected String department;
    private double salary;

    public Employee(String employeeID, String department, double salary) {
        this.employeeID = employeeID;
        this.department = department;
        this.salary = salary;
    }

    // Public methods to access/modify private salary
    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        if (salary >= 0) {
            this.salary = salary;
        } else {
            System.out.println("Invalid salary");
        }
    }

    public void displayDetails() {
        System.out.println("Employee Details:");
        System.out.println("Employee ID: " + employeeID);
        System.out.println("Department: " + department);
        System.out.println("Salary: $" + salary);
    }
}

class Manager extends Employee {
    public Manager(String employeeID, String department, double salary) {
        super(employeeID, department, salary);
    }

    public void displayManagerDetails() {
        System.out.println("Manager Details:");
        System.out.println("Employee ID: " + employeeID); // Public member
        System.out.println("Department: " + department); // Protected member
        System.out.println("Salary: $" + getSalary()); // Private member via getter
    }

    public static void main(String[] args) {
        Employee emp = new Employee("E001", "IT", 50000.0);
        Manager mgr = new Manager("M001", "HR", 75000.0);
        emp.displayDetails();
        mgr.displayManagerDetails();
        mgr.setSalary(80000.0);
        mgr.displayManagerDetails();
    }
}