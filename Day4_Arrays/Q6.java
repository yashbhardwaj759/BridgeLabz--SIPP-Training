package Day4_Arrays;
import java.util.Scanner;
public class Q6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[] numbers = new double[10];
        double total = 0.0;
        int index = 0;
        System.out.println("Enter numbers (max 10, stop at 0 or negative):");
        while (true) {
            double value = sc.nextDouble();

            if (value <= 0 || index == 10) {
                break;
            }
            numbers[index++] = value;
        }
        System.out.println("Numbers entered:");
        for (int i = 0; i < index; i++) {
            System.out.print(numbers[i] + " ");
            total += numbers[i];
        }
        System.out.println("\nSum = " + total);
    }
}
