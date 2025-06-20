public class MostFrequentCharacter {
    public static void main(String[] args) {
        String input = "success";
        int[] freq = new int[256];
        for (int i = 0; i < input.length(); i++) {
            freq[input.charAt(i)]++;
        }
        int max = 0;
        char result = ' ';
        for (int i = 0; i < input.length(); i++) {
            if (freq[input.charAt(i)] > max) {
                max = freq[input.charAt(i)];
                result = input.charAt(i);
            }
        }
        System.out.println("Most Frequent Character: '" + result + "'");
    }
} 