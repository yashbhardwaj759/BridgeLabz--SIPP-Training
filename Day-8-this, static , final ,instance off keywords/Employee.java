public class Employee {
    // Static variable
    private static String companyName = "Tech Corp";
    private static int totalEmployees = 0;

    // Instance variables
    private String name;
    private final String id;
    private String designation;

    // Constructor using this
    public Employee(String name, String id, String designation) {
        this.name = name;
        this.id = id;
        this.designation = designation;
        totalEmployees++;
    }

    // Static method
    public static void displayTotalEmployees() {
        System.out.println("Total Employees in " + companyName + ": " + totalEmployees);
    }

    // Instance method with instanceof check
    public void displayDetails(Object obj) {
        if (obj instanceof Employee) {
            Employee emp = (Employee) obj;
            System.out.println("Employee Details:");
            System.out.println("Company: " + companyName);
            System.out.println("Name: " + emp.name);
            System.out.println("ID: " + emp.id);
            System.out.println("Designation: " + emp.designation);
        } else {
            System.out.println("Invalid object: Not an Employee instance");
        }
    }

    public static void main(String[] args) {
        Employee emp1 = new Employee("Alice", "EMP001", "Developer");
        Employee emp2 = new Employee("Bob", "EMP002", "Manager");
        emp1.displayDetails(emp1);
        emp2.displayDetails(emp2);
        Employee.displayTotalEmployees();
        emp1.displayDetails(new String("Invalid"));
    }
}