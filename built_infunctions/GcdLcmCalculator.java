import java.util.Scanner;

public class GcdLcmCalculator {
    public static void main(String[] args) {
        int a = getInput("Enter first number: ");
        int b = getInput("Enter second number: ");
        int gcd = computeGCD(a, b);
        int lcm = computeLCM(a, b, gcd);
        System.out.println("GCD: " + gcd);
        System.out.println("LCM: " + lcm);
    }

    public static int getInput(String message) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(message);
        return scanner.nextInt();
    }

    public static int computeGCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static int computeLCM(int a, int b, int gcd) {
        return (a * b) / gcd;
    }
}