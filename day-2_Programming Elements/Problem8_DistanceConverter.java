import java.util.Scanner;

public class Problem8_DistanceConverter {
    public static void main(String[] args) {
        // Create Scanner object
        Scanner input = new Scanner(System.in);
        
        // Get input from user
        System.out.print("Enter distance in kilometers: ");
        double km = input.nextDouble();
        
        // Calculate miles
        double miles = km / 1.6;
        
        // Display result
        System.out.println("The total miles is " + miles + " mile for the given " + km + " km");
        
        // Close scanner
        input.close();
    }
} 