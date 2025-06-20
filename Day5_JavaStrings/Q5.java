package Day5_JavaStrings;
import java.util.Scanner;
class Q5 {
    public static boolean compareCharAt(String a, String b) {
        if (a.length() != b.length()) return false;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
        boolean resultManual = compareCharAt(s1, s2);
        boolean resultBuiltIn = s1.equals(s2);
        System.out.println("Manual Compare: " + resultManual);
        System.out.println("Built-in Compare: " + resultBuiltIn);
    }
}