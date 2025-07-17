import java.util.Scanner;

/**
 * Implements the School Results Application with aggregation between Student and Subject.
 * Demonstrates Class Diagram (structure), Object Diagram (snapshot), and Sequence Diagram (interaction).
 * Adheres to UML best practices: clear naming, focused classes, proper relationships.
 * Guideline #1: Uses composition (aggregation) instead of inheritance.
 * Guideline #7: Private fields with getters.
 */
public class SchoolResultsApplication {
    /**
     * Represents a subject with marks, analogous to a ride in the cab service.
     */
    static class Subject {
        private String name;
        private double marks;

        public Subject(String name, double marks) {
            this.name = name;
            this.marks = marks;
        }

        public String getName() {
            return name;
        }

        public double getMarks() {
            return marks;
        }

        public String getDetails() {
            return "Subject: " + name + ", Marks: " + marks;
        }
    }

    /**
     * Student aggregates Subject objects (aggregation relationship).
     * Methods like enrollSubject are analogous to multipleRides.
     */
    static class Student {
        private String name;
        private Subject[] subjects;
        private int subjectCount;
        private static final int MAX_SUBJECTS = 10;

        public Student(String name) {
            this.name = name;
            this.subjects = new Subject[MAX_SUBJECTS];
            this.subjectCount = 0;
        }

        public void enrollSubject(Scanner scanner) {
            System.out.print("Enter number of subjects for " + name + ": ");
            int numSubjects = scanner.nextInt();
            scanner.nextLine();
            if (subjectCount + numSubjects > MAX_SUBJECTS) {
                throw new IllegalStateException("Cannot enroll more subjects");
            }

            for (int i = 0; i < numSubjects; i++) {
                System.out.print("Enter subject name: ");
                String subjectName = scanner.nextLine();
                System.out.print("Enter marks for " + subjectName + ": ");
                double marks = scanner.nextDouble();
                scanner.nextLine();
                subjects[subjectCount++] = new Subject(subjectName, marks);
            }
        }

        public String getDetails() {
            StringBuilder sb = new StringBuilder("Student: " + name + "\nSubjects:\n");
            for (int i = 0; i < subjectCount; i++) {
                sb.append(subjects[i].getDetails()).append("\n");
            }
            return sb.toString();
        }

        public Subject[] getSubjects() {
            return subjects;
        }

        public int getSubjectCount() {
            return subjectCount;
        }

        public String getName() {
            return name;
        }
    }

    /**
     * Calculates grades, analogous to invoiceService in cab service.
     * Demonstrates sequence diagram interaction for grade calculation.
     */
    static class GradeCalculator {
        private static final double PASS_MARK = 50.0;
        private static final double BONUS_THRESHOLD = 3; // Bonus for 3+ subjects
        private static final double BONUS_MULTIPLIER = 1.1; // 10% grade boost

        public String calculateGrade(Student student) {
            double totalMarks = 0.0;
            int subjectCount = student.getSubjectCount();
            Subject[] subjects = student.getSubjects();

            // Sequence: Iterate through subjects to calculate total
            for (int i = 0; i < subjectCount; i++) {
                totalMarks += subjects[i].getMarks();
            }

            double average = subjectCount > 0 ? totalMarks / subjectCount : 0.0;
            average = subjectCount >= BONUS_THRESHOLD ? average * BONUS_MULTIPLIER : average;
            String grade = average >= PASS_MARK ? "Pass" : "Fail";

            // Enhanced report, analogous to enhanceInvoice
            StringBuilder report = new StringBuilder("Grade Report for " + student.getName() + "\n");
            report.append("----------------------------------------\n");
            report.append(String.format("%-15s %-10s\n", "Subject", "Marks"));
            report.append("----------------------------------------\n");
            for (int i = 0; i < subjectCount; i++) {
                report.append(String.format("%-15s %-10.2f\n", 
                    subjects[i].getName(), subjects[i].getMarks()));
            }
            report.append("----------------------------------------\n");
            report.append AlphaString.format("Average: %.2f\n", average));
            report.append("Grade: ").append(grade).append("\n");
            return report.toString();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Object Diagram Snapshot: John with Maths and Science
        Student john = new Student("John");
        john.enrollSubject(scanner); // User inputs subjects (e.g., Maths:90, Science:85)

        // Sequence Diagram: Calculate grade
        GradeCalculator calculator = new GradeCalculator();
        System.out.println(john.getDetails()); // Snapshot of objects
        System.out.println(calculator.calculateGrade(john)); // Interaction sequence

        scanner.close();
    }
}