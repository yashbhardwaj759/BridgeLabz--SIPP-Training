package Day5_JavaStrings;
import java.util.Scanner;
class Q9 {
    public static int getLength(String str) {
        int count = 0;
        try {
            while (true) {
                str.charAt(count);
                count++;
            }
        } catch (Exception e) {
            return count;
        }
    }
    public static String[] splitManual(String str) {
        str += " ";
        String word = "";
        java.util.ArrayList<String> words = new java.util.ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch != ' ') word += ch;
            else {
                if (!word.equals("")) words.add(word);
                word = "";
            }
        }
        return words.toArray(new String[0]);
    }
    public static boolean compareArrays(String[] a, String[] b) {
        if (a.length != b.length) return false;
        for (int i = 0; i < a.length; i++) {
            if (!a[i].equals(b[i])) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] builtIn = str.split(" ");
        String[] manual = splitManual(str);
        System.out.println("Equal: " + compareArrays(builtIn, manual));
    }
}
