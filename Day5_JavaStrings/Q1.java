package Day5_JavaStrings;
import java.util.Scanner;
class Q1 {
    public static void generateException(String str) {
        System.out.println(str.charAt(str.length()));
    }
    public static void handleException(String str) {
        try {
            System.out.println(str.charAt(str.length()));
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Exception Handled: " + e);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        handleException(str);
    }
}
