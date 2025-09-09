import java.util.Scanner;

public class FibonacciGenerator {
    public static void main(String[] args) {
        int terms = getInput();
        printFibonacci(terms);
    }

    public static int getInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of terms: ");
        return scanner.nextInt();
    }

    public static void printFibonacci(int n) {
        int a = 0, b = 1;
        for (int i = 0; i < n; i++) {
            System.out.print(a + " ");
            int next = a + b;
            a = b;
            b = next;
        }
    }
}