package Day5_JavaStrings;
import java.util.Scanner;
class Q4 {
    public static String toLowerManual(String str) {
        String result = "";
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch >= 'A' && ch <= 'Z') {
                result += (char)(ch + 32);
            } else {
                result += ch;
            }
        }
        return result;
    }
     public static boolean compareStrings(String a, String b) {
        if (a.length() != b.length()) return false;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String builtInLower = input.toLowerCase();
        String manualLower = toLowerManual(input);
        System.out.println("Manual: " + manualLower);
        System.out.println("Built-in: " + builtInLower);
        System.out.println("Equal: " + compareStrings(builtInLower, manualLower));
    }
}