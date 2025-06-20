package Day5_JavaStrings;
import java.util.Scanner;
class Q17 {
    public static String charType(char ch) {
        if (ch >= 'A' && ch <= 'Z') ch += 32;
        if (ch >= 'a' && ch <= 'z')
            return "aeiou".indexOf(ch) >= 0 ? "Vowel" : "Consonant";
        return "Not a Letter";
    }
    public static String[][] analyzeCharacters(String str) {
        String[][] result = new String[str.length()][2];
        for (int i = 0; i < str.length(); i++) {
            result[i][0] = String.valueOf(str.charAt(i));
            result[i][1] = charType(str.charAt(i));
        }
        return result;
    }
    public static void display(String[][] data) {
        System.out.println("Char\tType");
        for (String[] row : data)
            System.out.println(row[0] + "\t" + row[1]);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        display(analyzeCharacters(input));
    }
}
