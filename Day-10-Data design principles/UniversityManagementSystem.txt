import java.util.Scanner;

/**
 * Demonstrates aggregation (University-Student/Professor) and association (Student-Course, Professor-Course).
 * Integrates cab service-like enrollment tracking.
 */
public class UniversityManagementSystem {
    static class Course {
        private String courseName;
        private Student[] students;
        private int studentCount;
        private Professor professor;
        private static final int MAX_STUDENTS = 100;

        public Course(String courseName) {
            this.courseName = courseName;
            this.students = new Student[MAX_STUDENTS];
            this.studentCount = 0;
        }

        public void assignProfessor(Professor professor) {
            this.professor = professor;
            professor.addCourse(this);
        }

        public void addStudent(Student student) {
            if (studentCount >= MAX_STUDENTS) {
                throw new IllegalStateException("Course is full");
            }
            students[studentCount++] = student;
        }

        public String getDetails() {
            StringBuilder sb = new StringBuilder("Course: " + courseName + "\n");
            sb.append("Professor: ").append(professor != null ? professor.getName() : "None").append("\n");
            sb.append("Students:\n");
            for (int i = 0; i < studentCount; i++) {
                sb.append(students[i].getName()).append("\n");
            }
            return sb.toString();
        }
    }

    static class Student {
        private String name;
        private Course[] courses;
        private int courseCount;
        private static final int MAX_COURSES = 10;

        public Student(String name) {
            this.name = name;
            this.courses = new Course[MAX_COURSES];
            this.courseCount = 0;
        }

        public void enrollCourse(Course course) {
            if (courseCount >= MAX_COURSES) {
                throw new IllegalStateException("Student cannot enroll in more courses");
            }
            courses[courseCount++] = course;
            course.addStudent(this);
        }

        public String getName() {
            return name;
        }

        public String getCourses() {
            StringBuilder sb = new StringBuilder("Student: " + name + "\nCourses:\n");
            for (int i = 0; i < courseCount; i++) {
                sb.append(courses[i].courseName).append("\n");
            }
            return sb.toString();
        }
    }

    static class Professor {
        private String name;
        private Course[] courses;
        private int courseCount;
        private static final int MAX_COURSES = 5;

        public Professor(String name) {
            this.name = name;
            this.courses = new Course[MAX_COURSES];
            this.courseCount = 0;
        }

        public void addCourse(Course course) {
            if (courseCount >= MAX_COURSES) {
                throw new IllegalStateException("Professor cannot teach more courses");
            }
            courses[courseCount++] = course;
        }

        public String getName() {
            return name;
        }

        public String getCourses() {
            StringBuilder sb = new StringBuilder("Professor: " + name + "\nCourses:\n");
            for (int i = 0; i < courseCount; i++) {
                sb.append(courses[i].courseName).append("\n");
            }
            return sb.toString();
        }
    }

    static class University {
        private String name;
        private Student[] students;
        private int studentCount;
        private Professor[] professors;
        private int professorCount;
        private static final int MAX_STUDENTS = 100;
        private static final int MAX_PROFESSORS = 50;

        public University(String name) {
            this.name = name;
            this.students = new Student[MAX_STUDENTS];
            this.professors = new Professor[MAX_PROFESSORS];
            this.studentCount = 0;
            this.professorCount = 0;
        }

        public void addStudent(Student student) {
            if (studentCount >= MAX_STUDENTS) {
                throw new IllegalStateException("University is full of students");
            }
            students[studentCount++] = student;
        }

        public void addProfessor(Professor professor) {
            if (professorCount >= MAX_PROFESSORS) {
                throw new IllegalStateException("University is full of professors");
            }
            professors[professorCount++] = professor;
        }

        public String getDetails() {
            StringBuilder sb = new StringBuilder("University: " + name + "\nStudents:\n");
            for (int i = 0; i < studentCount; i++) {
                sb.append(students[i].getName()).append("\n");
            }
            sb.append("Professors:\n");
            for (int i = 0; i < professorCount; i++) {
                sb.append(professors[i].getName()).append("\n");
            }
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter university name: ");
        String uniName = scanner.nextLine();
        University university = new University(uniName);

        System.out.print("Enter number of students: ");
        int numStudents = scanner.nextInt();
        scanner.nextLine();

        Student[] students = new Student[numStudents];
        for (int i = 0; i < numStudents; i++) {
            System.out.print("Enter student name: ");
            String name = scanner.nextLine();
            students[i] = new Student(name);
            university.addStudent(students[i]);
        }

        System.out.print("Enter number of professors: ");
        int numProfessors = scanner.nextInt();
        scanner.nextLine();

        Professor[] professors = new Professor[numProfessors];
        for (int i = 0; i < numProfessors; i++) {
            System.out.print("Enter professor name: ");
            String name = scanner.nextLine();
            professors[i] = new Professor(name);
            university.addProfessor(professors[i]);
        }

        System.out.print("Enter number of courses: ");
        int numCourses = scanner.nextInt();
        scanner.nextLine();

        Course[] courses = new Course[numCourses];
        for (int i = 0; i < numCourses; i++) {
            System.out.print("Enter course name: ");
            String courseName = scanner.nextLine();
            courses[i] = new Course(courseName);

            System.out.print("Enter professor index (0-" + (numProfessors - 1) + "): ");
            int profIndex = scanner.nextInt();
            scanner.nextLine();
            courses[i].assignProfessor(professors[profIndex]);

            System.out.print("Enter number of students for " + courseName + ": ");
            int numEnroll = scanner.nextInt();
            scanner.nextLine();

            for (int j = 0; j < numEnroll; j++) {
                System.out.print("Enter student index (0-" + (numStudents - 1) + "): ");
                int studentIndex = scanner.nextInt();
                scanner.nextLine();
                students[studentIndex].enrollCourse(courses[i]);
            }
        }

        System.out.println(university.getDetails());
        for (Student student : students) {
            System.out.println(student.getCourses());
        }
        for (Professor professor : professors) {
            System.out.println(professor.getCourses());
        }
        for (Course course : courses) {
            System.out.println(course.getDetails());
        }

        scanner.close();
    }
}