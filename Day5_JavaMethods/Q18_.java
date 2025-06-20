package Day5_JavaMethods;
import java.util.Scanner;
public class Q18_{
    public static double averageDigits(int n) {
        int sum = 0, count = 0;
        while (n > 0) {
            sum += n % 10;
            count++;
            n /= 10;
        }
        return (double) sum / count;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number: ");
        int n = sc.nextInt();
        System.out.printf("Average of digits: %.2f", averageDigits(n));
    }
}
