import java.util.Scanner;

public class Problem9_UniversityFeeInput {
    public static void main(String[] args) {
        // Create Scanner object
        Scanner input = new Scanner(System.in);
        
        // Get input from user
        System.out.print("Enter the course fee: ");
        double fee = input.nextDouble();
        
        System.out.print("Enter the discount percentage: ");
        double discountPercent = input.nextDouble();
        
        // Calculate discount amount
        double discount = (fee * discountPercent) / 100.0;
        
        // Calculate final fee
        double finalFee = fee - discount;
        
        // Display results
        System.out.println("The discount amount is INR " + discount + 
                         " and final discounted fee is INR " + finalFee);
        
        // Close scanner
        input.close();
    }
} 