// Question 17
import java.util.Scanner;
public class Q17 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double side1 = sc.nextDouble();
        double side2 = sc.nextDouble();
        double side3 = sc.nextDouble();
        double perimeter = side1 + side2 + side3;
        double rounds = (5000.0 / perimeter);
        System.out.println("The total number of rounds the athlete will run is " + rounds + " to complete 5 km");
    }
}