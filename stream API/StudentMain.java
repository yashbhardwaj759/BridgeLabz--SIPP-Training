import java.util.*;
import java.util.stream.*;

class Student {
    int id, marks;
    String name;

    Student(int id, String name, int marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }
}

public class StudentMain {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student(1, "John", 85),
                new Student(2, "Emma", 30),
                new Student(3, "Alex", 50),
                new Student(4, "Sophia", 25));

        Map<Boolean, List<String>> partitioned = students.stream()
                .collect(Collectors.partitioningBy(s -> s.marks >= 40,
                        Collectors.mapping(s -> s.name, Collectors.toList())));

        System.out.println(partitioned);
    }
}