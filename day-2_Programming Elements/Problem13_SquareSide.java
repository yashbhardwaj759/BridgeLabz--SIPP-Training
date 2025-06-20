import java.util.Scanner;

public class Problem13_SquareSide {
    public static void main(String[] args) {
        // Create Scanner object
        Scanner input = new Scanner(System.in);
        
        // Get input from user
        System.out.print("Enter perimeter of square: ");
        double perimeter = input.nextDouble();
        
        // Calculate side length
        double side = perimeter / 4;
        
        // Display result
        System.out.println("The length of the side is " + side + " whose perimeter is " + perimeter);
        
        // Close scanner
        input.close();
    }
} 