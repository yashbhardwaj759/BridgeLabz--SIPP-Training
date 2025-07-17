public class Circle {
    private double radius;

    // Default constructor
    public Circle() {
        this(1.0); // Calls parameterized constructor
    }

    // Parameterized constructor
    public Circle(double radius) {
        this.radius = radius;
    }

    public void displayDetails() {
        System.out.println("Circle Details:");
        System.out.println("Radius: " + radius);
        System.out.println("Area: " + (Math.PI * radius * radius));
    }

    public static void main(String[] args) {
        Circle circle1 = new Circle();
        Circle circle2 = new Circle(5.0);
        circle1.displayDetails();
        circle2.displayDetails();
    }
}