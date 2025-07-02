class Subject {
    private int marks;

    public Subject(int marks) {
        this.marks = marks;
    }

    public int getMarks() {
        return marks;
    }
}

class Student {
    private Subject[] subjects;

    public Student(Subject[] subjects) {
        this.subjects = subjects;
    }

    public Subject[] getSubjects() {
        return subjects;
    }
}

class GradeCalculator {
    public static String calculateGrade(Student student) {
        Subject[] subjects = student.getSubjects();

        if (subjects == null || subjects.length == 0) {
            return "N/A";
        }

        int total = 0;
        for (Subject subject : subjects) {
            total += subject.getMarks();
        }

        double average = (double) total / subjects.length;

        if (average >= 90) return "A";
        else if (average >= 80) return "B";
        else if (average >= 70) return "C";
        else if (average >= 60) return "D";
        else return "F";
    }
}

public class GradeCalculatorApp { // <-- This class name must match file name if public
    public static void main(String[] args) {
        Subject[] subjects = {
            new Subject(85),
            new Subject(90),
            new Subject(78)
        };

        Student student = new Student(subjects);
        String grade = GradeCalculator.calculateGrade(student);
        System.out.println("Student's Grade: " + grade);
    }
}
