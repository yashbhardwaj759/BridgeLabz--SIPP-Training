package Day5_JavaMethods;
import java.util.Scanner;
public class Q17_{
    public static int sumEvenDigits(int n) {
        int sum = 0;
        while (n > 0) {
            int d = n % 10;
            if (d % 2 == 0) sum += d;
            n /= 10;
        }
        return sum;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number: ");
        int n = sc.nextInt();
        System.out.println("Sum of even digits: " + sumEvenDigits(n));
    }
}
