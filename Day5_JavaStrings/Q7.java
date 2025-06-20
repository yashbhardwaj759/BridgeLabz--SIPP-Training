package Day5_JavaStrings;
import java.util.Scanner;
class Q7 {
    public static void generateException() {
        String text = null;
        System.out.println(text.length());
    }
    public static void handleException() {
        try {
            String text = null;
            System.out.println(text.length());
        } catch (NullPointerException e) {
            System.out.println("Exception Handled: " + e);
        }
    }
    public static void main(String[] args) {
        // generateException();
        handleException();
    }
}
