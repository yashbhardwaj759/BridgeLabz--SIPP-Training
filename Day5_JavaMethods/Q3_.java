package Day5_JavaMethods;
import java.util.Scanner;
public class Q3_{
    public static double calculateRounds(double a, double b, double c) {
        double perimeter = a + b + c;
        return 5000 / perimeter; // 5km = 5000 meters
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter side a: ");
        double a = sc.nextDouble();
        System.out.print("Enter side b: ");
        double b = sc.nextDouble();
        System.out.print("Enter side c: ");
        double c = sc.nextDouble();
        double rounds = calculateRounds(a, b, c);
        System.out.println("Number of rounds needed: " + Math.ceil(rounds));
    }
}
