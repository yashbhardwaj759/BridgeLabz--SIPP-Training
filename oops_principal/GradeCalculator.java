package oops_principal;

public class GradeCalculator {
    public static String calculateGrade(Student student) {
        Subject[] subjects = student.getSubjects();
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