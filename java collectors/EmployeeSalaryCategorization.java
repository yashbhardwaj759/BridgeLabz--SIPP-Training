package JavaCollectors;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EmployeeSalaryCategorization {

    static class Employee {
        String name;
        String department;
        double salary;

        public Employee(String name, String department, double salary) {
            this.name = name;
            this.department = department;
            this.salary = salary;
        }

        public String getName() {
            return name;
        }

        public String getDepartment() {
            return department;
        }

        public double getSalary() {
            return salary;
        }

        @Override
        public String toString() {
            return "Employee{name='" + name + "', department='" + department + "', salary=" + salary + "}";
        }
    }

    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("Alice", "HR", 60000),
                new Employee("Bob", "Engineering", 90000),
                new Employee("Charlie", "HR", 65000),
                new Employee("David", "Engineering", 95000),
                new Employee("Eve", "Sales", 70000),
                new Employee("Frank", "Engineering", 85000)
        );

        // Group employees by department and calculate the average salary for each department
        Map<String, Double> avgSalaryByDept = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.averagingDouble(Employee::getSalary)
                ));

        System.out.println("Average salary by department:");
        avgSalaryByDept.forEach((department, avgSalary) ->
                System.out.println(department + ": " + String.format("%.2f", avgSalary))
        );
    }
}
