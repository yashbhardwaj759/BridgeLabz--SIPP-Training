package oops_principal;

public class Main {
    public static void main(String[] args) {
        Subject[] subjects = {
            new Subject("Maths", 90),
            new Subject("Science", 85)
        };
        Student student = new Student("John", subjects);
        String grade = GradeCalculator.calculateGrade(student);
        System.out.println("Student: " + student.getName());
        for (Subject subject : student.getSubjects()) {
            System.out.println("Subject: " + subject.getName() + ", Marks: " + subject.getMarks());
        }
        System.out.println("Grade: " + grade);
    }
} 