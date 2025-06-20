package Day5_JavaStrings;
import java.util.Scanner;
class Q11 {
    public static int[] getTrimIndices(String str) {
        int start = 0, end = str.length() - 1;
        while (start < str.length() && str.charAt(start) == ' ') start++;
        while (end >= 0 && str.charAt(end) == ' ') end--;
        return new int[]{start, end + 1};
    }
    public static String customSubstring(String str, int start, int end) {
        String res = "";
        for (int i = start; i < end; i++) res += str.charAt(i);
        return res;
    }
    public static boolean compare(String a, String b) {
        if (a.length() != b.length()) return false;
        for (int i = 0; i < a.length(); i++)
            if (a.charAt(i) != b.charAt(i)) return false;
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        int[] indices = getTrimIndices(input);
        String trimmedCustom = customSubstring(input, indices[0], indices[1]);
        String trimmedBuiltIn = input.trim();
        System.out.println("Custom Trimmed: " + trimmedCustom);
        System.out.println("Built-in Trimmed: " + trimmedBuiltIn);
        System.out.println("Equal: " + compare(trimmedCustom, trimmedBuiltIn));
    }
}