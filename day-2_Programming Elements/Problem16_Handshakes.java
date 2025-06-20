import java.util.Scanner;

public class Problem16_Handshakes {
    public static void main(String[] args) {
        // Create Scanner object
        Scanner input = new Scanner(System.in);
        
        // Get input from user
        System.out.print("Enter number of students: ");
        int numberOfStudents = input.nextInt();
        
        // Calculate maximum number of handshakes
        int maxHandshakes = (numberOfStudents * (numberOfStudents - 1)) / 2;
        
        // Display result
        System.out.println("The maximum number of possible handshakes among " + 
                         numberOfStudents + " students is " + maxHandshakes);
        
        // Close scanner
        input.close();
    }
} 