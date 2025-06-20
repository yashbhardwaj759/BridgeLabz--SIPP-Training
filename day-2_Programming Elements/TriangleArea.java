import java.util.Scanner;

public class TriangleArea {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter base in cm: ");
        double base = scanner.nextDouble();
        
        System.out.print("Enter height in cm: ");
        double height = scanner.nextDouble();
        
        // Calculate area in square centimeters
        double areaCm = 0.5 * base * height;
        
        // Convert to square inches (1 inch = 2.54 cm)
        double areaIn = areaCm / (2.54 * 2.54);
        
        System.out.printf("The Area of the triangle in sq in is %.2f and sq cm is %.2f%n", areaIn, areaCm);
        
        scanner.close();
    }
} 