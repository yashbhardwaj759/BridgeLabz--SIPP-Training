import java.util.Scanner;

/**
 * Demonstrates composition: Company owns Departments and Employees.
 * Guideline #1: Uses composition for Department and Employee.
 */
public class CompanyDepartments {
    static class Employee {
        private String name;
        private String employeeId;

        public Employee(String name, String employeeId) {
            this.name = name;
            this.employeeId = employeeId;
        }

        public String getDetails() {
            return "Employee: " + name + ", ID: " + employeeId;
        }
    }

    static class Department {
        private String deptName;
        private Employee[] employees;
        private int employeeCount;
        private static final int MAX_EMPLOYEES = 50;

        public Department(String deptName) {
            this.deptName = deptName;
            this.employees = new Employee[MAX_EMPLOYEES];
            this.employeeCount = 0;
        }

        public void addEmployee(Employee employee) {
            if (employeeCount >= MAX_EMPLOYEES) {
                throw new IllegalStateException("Department is full");
            }
            employees[employeeCount++] = employee;
        }

        public String getDetails() {
            StringBuilder sb = new StringBuilder("Department: " + deptName + "\nEmployees:\n");
            for (int i = 0; i < employeeCount; i++) {
                sb.append(employees[i].getDetails()).append("\n");
            }
            return sb.toString();
        }
    }

    static class Company {
        private String name;
        private Department[] departments;
        private int deptCount;
        private static final int MAX_DEPARTMENTS = 10;

        public Company(String name) {
            this.name = name;
            this.departments = new Department[MAX_DEPARTMENTS];
            this.deptCount = 0;
        }

        public void addDepartment(String deptName) {
            if (deptCount >= MAX_DEPARTMENTS) {
                throw new IllegalStateException("Cannot add more departments");
            }
            departments[deptCount++] = new Department(deptName);
        }

        public void addEmployeeToDepartment(String deptName, String empName, String empId) {
            for (int i = 0; i < deptCount; i++) {
                if (departments[i].deptName.equals(deptName)) {
                    departments[i].addEmployee(new Employee(empName, empId));
                    return;
                }
            }
            throw new IllegalArgumentException("Department not found");
        }

        public String getDetails() {
            StringBuilder sb = new StringBuilder("Company: " + name + "\n");
            for (int i = 0; i < deptCount; i++) {
                sb.append(departments[i].getDetails()).append("\n");
            }
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter company name: ");
        String companyName = scanner.nextLine();
        Company company = new Company(companyName);

        System.out.print("Enter number of departments: ");
        int numDepts = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < numDepts; i++) {
            System.out.print("Enter department name: ");
            String deptName = scanner.nextLine();
            company.addDepartment(deptName);

            System.out.print("Enter number of employees for " + deptName + ": ");
            int numEmps = scanner.nextInt();
            scanner.nextLine();

            for (int j = 0; j < numEmps; j++) {
                System.out.print("Enter employee name: ");
                String empName = scanner.nextLine();
                System.out.print("Enter employee ID: ");
                String empId = scanner.nextLine();
                company.addEmployeeToDepartment(deptName, empName, empId);
            }
        }

        System.out.println(company.getDetails());
        scanner.close();
    }
}