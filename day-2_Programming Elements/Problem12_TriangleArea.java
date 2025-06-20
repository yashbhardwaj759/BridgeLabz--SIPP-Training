import java.util.Scanner;

public class Problem12_TriangleArea {
    public static void main(String[] args) {
        // Create Scanner object
        Scanner input = new Scanner(System.in);
        
        // Get input from user
        System.out.print("Enter base of triangle: ");
        double base = input.nextDouble();
        
        System.out.print("Enter height of triangle: ");
        double height = input.nextDouble();
        
        // Calculate area in square inches
        double areaInches = 0.5 * base * height;
        
        // Convert to square centimeters (1 inch = 2.54 cm)
        double areaCm = areaInches * Math.pow(2.54, 2);
        
        // Display results
        System.out.println("The area of triangle is " + areaInches + " square inches and " + 
                         areaCm + " square centimeters");
        
        // Close scanner
        input.close();
    }
} 