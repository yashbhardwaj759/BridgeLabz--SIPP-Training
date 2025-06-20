import java.util.Scanner;

public class StudentFeeDiscount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the student fee: ");
        double fee = scanner.nextDouble();
        System.out.print("Enter the university discount percent: ");
        double discountPercent = scanner.nextDouble();
        double discount = (fee * discountPercent) / 100.0;
        double finalFee = fee - discount;
        System.out.printf("The discount amount is INR %.2f and final discounted fee is INR %.2f\n", discount, finalFee);
        scanner.close();
    }
} 