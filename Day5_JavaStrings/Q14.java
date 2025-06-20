package Day5_JavaStrings;
import java.util.Scanner;
class Q14 {
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
            while (true) str.charAt(count++);
        } catch (Exception e) {
            return count;
        }
    }
    public static int[] findShortestLongest(String[] words) {
        int min = Integer.MAX_VALUE, max = 0, minIdx = 0, maxIdx = 0;
        for (int i = 0; i < words.length; i++) {
            int len = getLength(words[i]);
            if (len < min) { min = len; minIdx = i; }
            if (len > max) { max = len; maxIdx = i; }
        }
        return new int[]{minIdx, maxIdx};
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] words = splitManual(input);
        int[] indices = findShortestLongest(words);
        System.out.println("Shortest: " + words[indices[0]]);
        System.out.println("Longest: " + words[indices[1]]);
    }
}
