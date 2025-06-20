package Day5_JavaMethods;
import java.util.Scanner;
public class Q13_{
    public static int findLargestDigit(int n) {
        int largest = 0;
        while (n > 0) {
            int digit = n % 10;
            if (digit > largest) largest = digit;
            n /= 10;
        }
        return largest;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number: ");
        int n = sc.nextInt();
        System.out.println("Largest digit: " + findLargestDigit(n));
    }
}
