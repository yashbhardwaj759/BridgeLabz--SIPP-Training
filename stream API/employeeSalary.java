import java.util.*;
import java.util.stream.*;
import java.util.function.Function;

class Employee {
    int id;
    String name, dept;
    int salary;

    Employee(int id, String name, String dept, int salary) {
        this.id = id;
        this.name = name;
        this.dept = dept;
        this.salary = salary;
    }
}

public class employeeSalary {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee(1, "Alice", "IT", 60000),
                new Employee(2, "Bob", "Finance", 55000),
                new Employee(3, "Charlie", "IT", 70000),
                new Employee(4, "David", "HR", 50000),
                new Employee(5, "Eve", "Finance", 65000));

        Map<String, String> result = employees.stream()
                .collect(Collectors.groupingBy(e -> e.dept,
                        Collectors.collectingAndThen(
                                Collectors.maxBy(Comparator.comparingInt(e -> e.salary)),
                                opt -> opt.get().name)));

        System.out.println(result);
    }
}