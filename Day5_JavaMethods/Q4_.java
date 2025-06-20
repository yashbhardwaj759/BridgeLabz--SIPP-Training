package Day5_JavaMethods;
import java.util.Scanner;
public class Q4_{
    public static int checkNumber(int n) {
        if (n < 0) return -1;
        else if (n > 0) return 1;
        else return 0;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = sc.nextInt();
        int result = checkNumber(num);
        if (result == -1) System.out.println("Negative number");
        else if (result == 1) System.out.println("Positive number");
        else System.out.println("Zero");
    }
}
