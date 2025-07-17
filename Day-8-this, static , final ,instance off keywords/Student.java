public class Student {
    // Static variable
    private static String universityName = "State University";
    private static int totalStudents = 0;

    // Instance variables
    private String name;
    private final String rollNumber;
    private String grade;

    // Constructor using this
    public Student(String name, String rollNumber, String grade) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
        totalStudents++;
    }

    // Static method
    public static void displayTotalStudents() {
        System.out.println("Total Students in " + universityName + ": " + totalStudents);
    }

    // Instance method with instanceof check
    public void displayDetails(Object obj) {
        if (obj instanceof Student) {
            Student student = (Student) obj;
            System.out.println("Student Details:");
            System.out.println("University: " + universityName);
            System.out.println("Name: " + student.name);
            System.out.println("Roll Number: " + student.rollNumber);
            System.out.println("Grade: " + student.grade);
        } else {
            System.out.println("Invalid object: Not a Student instance");
        }
    }

    public static void main(String[] args) {
        Student s1 = new Student("Alice", "RN001", "A");
        Student s2 = new Student("Bob", "RN002", "B");
        s1.displayDetails(s1);
        s2.displayDetails(s2);
        Student.displayTotalStudents();
        s1.displayDetails(new String("Invalid"));
    }
}