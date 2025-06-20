package Day5_JavaStrings;
import java.util.Scanner;
class Q2 {
    public static void generateException(String text) {
        System.out.println(Integer.parseInt(text));
    }
    public static void handleException(String text) {
        try {
            System.out.println(Integer.parseInt(text));
        } catch (NumberFormatException e) {
            System.out.println("Exception Handled: " + e);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.next();
        // generateException(text);
        handleException(text);
    }
}