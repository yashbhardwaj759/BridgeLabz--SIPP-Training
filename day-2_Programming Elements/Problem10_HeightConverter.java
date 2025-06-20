import java.util.Scanner;

public class Problem10_HeightConverter {
    public static void main(String[] args) {
        // Create Scanner object
        Scanner input = new Scanner(System.in);
        
        // Get input from user
        System.out.print("Enter your height in centimeters: ");
        double heightCm = input.nextDouble();
        
        // Convert to inches
        double heightInches = heightCm / 2.54;
        
        // Convert to feet and remaining inches
        int feet = (int)(heightInches / 12);
        double inches = heightInches % 12;
        
        // Display results
        System.out.println("Your Height in cm is " + heightCm + 
                         " while in feet is " + feet + 
                         " and inches is " + inches);
        
        // Close scanner
        input.close();
    }
} 