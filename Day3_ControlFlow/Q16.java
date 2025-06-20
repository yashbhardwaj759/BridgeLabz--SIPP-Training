import java.util.Scanner;
public class Q16{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number less than 100: ");
        int number = sc.nextInt();
        int counter = number;
        System.out.println("Multiples of " + number + " below 100:");
        while (counter < 100) {
            System.out.println(counter);
            counter += number;
        }
    }
}
