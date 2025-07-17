import java.util.Scanner;

/**
 * Demonstrates composition (University-Department) and aggregation (University-Faculty).
 * Guideline #1: Uses composition for Department, aggregation for Faculty.
 */
public class UniversityFacultiesDepartments {
    static class Faculty {
        private String name;
        private String facultyId;

        public Faculty(String name, String facultyId) {
            this.name = name;
            this.facultyId = facultyId;
        }

        public String getDetails() {
            return "Faculty: " + name + ", ID: " + facultyId;
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

    static class University {
        private String name;
        private Department[] departments;
        private int deptCount;
        private Faculty[] faculties;
        private int facultyCount;
        private static final int MAX_DEPARTMENTS = 10;
        private static final int MAX_FACULTIES = 50;

        public University(String name) {
            this.name = name;
            this.departments = new Department[MAX_DEPARTMENTS];
            this.faculties = new Faculty[MAX_FACULTIES];
            this.deptCount = 0;
            this.facultyCount = 0;
        }

        public void addDepartment(String deptName) {
            if (deptCount >= MAX_DEPARTMENTS) {
                throw new IllegalStateException("Cannot add more departments");
            }
            departments[deptCount++] = new Department(deptName);
        }

        public void addFaculty(Faculty faculty) {
            if (facultyCount >= MAX_FACULTIES) {
                throw new IllegalStateException("Cannot add more faculties");
            }
            faculties[facultyCount++] = faculty;
        }

        public String getDetails() {
            StringBuilder sb = new StringBuilder("University: " + name + "\nDepartments:\n");
            for (int i = 0; i < deptCount; i++) {
                sb.append(departments[i].getDetails()).append("\n");
            }
            sb.append("Faculties:\n");
            for (int i = 0; i < facultyCount; i++) {
                sb.append(faculties[i].getDetails()).append("\n");
            }
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter university name: ");
        String uniName = scanner.nextLine();
        University university = new University(uniName);

        System.out.print("Enter number of departments: ");
        int numDepts = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < numDepts; i++) {
            System.out.print("Enter department name: ");
            String deptName = scanner.nextLine();
            university.addDepartment(deptName);
        }

        System.out.print("Enter number of faculties: ");
        int numFaculties = scanner.nextInt();
        scanner.nextLine();

        Faculty[] faculties = new Faculty[numFaculties];
        for (int i = 0; i < numFaculties; i++) {
            System.out.print("Enter faculty name: ");
            String name = scanner.nextLine();
            System.out.print("Enter faculty ID: ");
            String id = scanner.nextLine();
            faculties[i] = new Faculty(name, id);
            university.addFaculty(faculties[i]);
        }

        System.out.println(university.getDetails());
        // Faculties can exist independently
        System.out.println("Independent Faculty: " + faculties[0].getDetails());

        scanner.close();
    }
}