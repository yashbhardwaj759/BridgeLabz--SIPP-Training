package oops_principal;

public class Student {
    private String name;
    private Subject[] subjects;

    public Student(String name, Subject[] subjects) {
        this.name = name;
        this.subjects = subjects;
    }

    public String getName() {
        return name;
    }

    public Subject[] getSubjects() {
        return subjects;
    }
} 