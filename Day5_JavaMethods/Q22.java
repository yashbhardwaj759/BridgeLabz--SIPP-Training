package Day5_JavaMethods;
import java.util.Scanner;
public class Q22{
    public static double areaTriangle(double base, double height) {
        return (base * height) / 2;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter base: ");
        double base = sc.nextDouble();
        System.out.print("Enter height: ");
        double height = sc.nextDouble();
        System.out.println("Area of triangle: " + areaTriangle(base, height));
    }
}
