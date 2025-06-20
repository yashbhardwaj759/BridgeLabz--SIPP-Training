import java.util.Scanner;

public class Problem11_BasicCalculator {
    public static void main(String[] args) {
        // Create Scanner object
        Scanner input = new Scanner(System.in);
        
        // Get input from user
        System.out.print("Enter first number: ");
        double number1 = input.nextDouble();
        
        System.out.print("Enter second number: ");
        double number2 = input.nextDouble();
        
        // Perform calculations
        double addition = number1 + number2;
        double subtraction = number1 - number2;
        double multiplication = number1 * number2;
        double division = number1 / number2;
        
        // Display results
        System.out.println("The addition, subtraction, multiplication and division value of 2 numbers " + 
                         number1 + " and " + number2 + " is " + addition + ", " + subtraction + 
                         ", " + multiplication + ", and " + division);
        
        // Close scanner
        input.close();
    }
} 