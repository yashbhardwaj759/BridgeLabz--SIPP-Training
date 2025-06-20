package Day5_JavaMethods;
import java.util.Scanner;
public class Q21_{
    public static int sumEven(int n) {
        int sum = 0;
        for (int i = 2; i <= n; i += 2) sum += i;
        return sum;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter value of N: ");
        int n = sc.nextInt();
        System.out.println("Sum of even numbers: " + sumEven(n));
    }
}
