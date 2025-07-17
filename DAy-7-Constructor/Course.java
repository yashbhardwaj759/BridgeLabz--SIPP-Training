public class Course {
    // Instance variables
    private String courseName;
    private int duration;
    private double fee;
    // Class variable
    private static String instituteName = "EduInstitute";

    public Course(String courseName, int duration, double fee) {
        this.courseName = courseName;
        this.duration = duration;
        this.fee = fee;
    }

    // Instance method
    public void displayCourseDetails() {
        System.out.println("Course Details:");
        System.out.println("Course Name: " + courseName);
        System.out.println("Duration: " + duration + " months");
        System.out.println("Fee: $" + fee);
        System.out.println("Institute: " + instituteName);
    }

    // Class method
    public static void updateInstituteName(String newName) {
        instituteName = newName;
        System.out.println("Institute name updated to: " + instituteName);
    }

    public static void main(String[] args) {
        Course c1 = new Course("Java Programming", 3, 499.99);
        Course c2 = new Course("Data Science", 6, 999.99);
        c1.displayCourseDetails();
        c2.displayCourseDetails();
        Course.updateInstituteName("TechAcademy");
        c1.displayCourseDetails();
    }
}