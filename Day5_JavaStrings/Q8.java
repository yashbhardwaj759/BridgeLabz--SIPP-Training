package Day5_JavaStrings;
import java.util.Scanner;
class Q8 {
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
    public static String[][] getWordLength(String[] words) {
        String[][] result = new String[words.length][2];
        for (int i = 0; i < words.length; i++) {
            result[i][0] = words[i];
            result[i][1] = String.valueOf(getLength(words[i]));
        }
        return result;
    }
    public static void display(String[][] table) {
        System.out.println("Word\tLength");
        for (String[] row : table) {
            System.out.println(row[0] + "\t" + row[1]);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String[] words = splitManual(line);
        String[][] table = getWordLength(words);
        display(table);
    }
}
