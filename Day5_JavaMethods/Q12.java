package Day5_JavaMethods;
import java.util.Scanner;
public class Q12{
    public static int countDigits(int num) {
        if (num == 0) return 0;
        return 1 + countDigits(num / 10);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number: ");
        int num = sc.nextInt();
        System.out.println("Digit count: " + countDigits(num));
    }
}
