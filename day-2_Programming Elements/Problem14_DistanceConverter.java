import java.util.Scanner;

public class Problem14_DistanceConverter {
    public static void main(String[] args) {
        // Create Scanner object
        Scanner input = new Scanner(System.in);
        
        // Get input from user
        System.out.print("Enter distance in feet: ");
        double distanceInFeet = input.nextDouble();
        
        // Convert to yards and miles
        double distanceInYards = distanceInFeet / 3;
        double distanceInMiles = distanceInYards / 1760;
        
        // Display results
        System.out.println("The distance " + distanceInFeet + " feet is equal to " + 
                         distanceInYards + " yards and " + distanceInMiles + " miles");
        
        // Close scanner
        input.close();
    }
} 