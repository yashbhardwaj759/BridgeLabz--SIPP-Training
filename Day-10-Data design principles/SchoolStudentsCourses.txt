import java.util.Scanner;

/**
 * Demonstrates aggregation (School-Student) and association (Student-Course).
 * Integrates cab service-like enrollment tracking.
 */
public class SchoolStudentsCourses {
    static class Course {
        private String courseName;
        private Student[] students;
        private int studentCount;
        private static final int MAX_STUDENTS = 100;

        public Course(String courseName) {
            this.courseName = courseName;
            this.students = new Student[MAX_STUDENTS];
            this.studentCount = 0;
        }

        public void addStudent(Student student) {
            if (studentCount >= MAX_STUDENTS) {
                throw new IllegalStateException("Course is full");
            }
            students[studentCount++] = student;
        }

        public String getEnrolledStudents() {
            StringBuilder sb = new StringBuilder("Course: " + courseName + "\nStudents:\n");
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

        public void enrollInCourse(Course course) {
            if (courseCount >= MAX_COURSES) {
                throw new IllegalStateException("Student cannot enroll in more courses");
            }
            courses[courseCount++] = course;
            course.addStudent(this);
        }

        public String getName() {
            return name;
        }

        public String viewCourses() {
            StringBuilder sb = new StringBuilder("Student: " + name + "\nCourses:\n");
            for (int i = 0; i < courseCount; i++) {
                sb.append(courses[i].courseName).append("\n");
            }
            return sb.toString();
        }
    }

    static class School {
        private String name;
        private Student[] students;
        private int studentCount;
        private static final int MAX_STUDENTS = 100;

        public School(String name) {
            this.name = name;
            this.students = new Student[MAX_STUDENTS];
            this.studentCount = 0;
        }

        public void addStudent(Student student) {
            if (studentCount >= MAX_STUDENTS) {
                throw new IllegalStateException("School is full");
            }
            students[studentCount++] = student;
        }

        public String getDetails() {
            StringBuilder sb = new StringBuilder("School: " + name + "\nStudents:\n");
            for (int i = 0; i < studentCount; i++) {
                sb.append(students[i].getName()).append("\n");
            }
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter school name: ");
        String schoolName = scanner.nextLine();
        School school = new School(schoolName);

        System.out.print("Enter number of students: ");
        int numStudents = scanner.nextInt();
        scanner.nextLine();

        Student[] students = new Student[numStudents];
        for (int i = 0; i < numStudents; i++) {
            System.out.print("Enter student name: ");
            String name = scanner.nextLine();
            students[i] = new Student(name);
            school.addStudent(students[i]);
        }

        System.out.print("Enter number of courses: ");
        int numCourses = scanner.nextInt();
        scanner.nextLine();

        Course[] courses = new Course[numCourses];
        for (int i = 0; i < numCourses; i++) {
            System.out.print("Enter course name: ");
            String courseName = scanner.nextLine();
            courses[i] = new Course(courseName);

            System.out.print("Enter number of students for " + courseName + ": ");
            int numEnroll = scanner.nextInt();
            scanner.nextLine();

            for (int j = 0; j < numEnroll; j++) {
                System.out.print("Enter student index (0-" + (numStudents - 1) + "): ");
                int index = scanner.nextInt();
                scanner.nextLine();
                students[index].enrollInCourse(courses[i]);
            }
        }

        System.out.println(school.getDetails());
        for (Student student : students) {
            System.out.println(student.viewCourses());
        }
        for (Course course : courses) {
            System.out.println(course.getEnrolledStudents());
        }

        scanner.close();
    }
}