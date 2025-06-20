public class Problem6_UniversityFee {
    public static void main(String[] args) {
        // Initialize variables
        int fee = 125000;
        int discountPercent = 10;
        
        // Calculate discount amount
        double discount = (fee * discountPercent) / 100.0;
        
        // Calculate final fee
        double finalFee = fee - discount;
        
        // Display results
        System.out.println("The discount amount is INR " + discount + 
                         " and final discounted fee is INR " + finalFee);
    }
} 