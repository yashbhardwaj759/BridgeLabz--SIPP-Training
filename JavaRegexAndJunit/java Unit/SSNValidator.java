import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.util.Set;

public class RepeatingWordsFinder {
    
    public static List<String> findRepeatingWords(String text) {
        Set<String> seen = new HashSet<>();
        Set<String> repeating = new HashSet<>();
        
        // Convert to lowercase and split by word boundaries
        String[] words = text.toLowerCase().split("\\W+");
        
        for (String word : words) {
            if (word.length() > 0) {
                if (seen.contains(word)) {
                    repeating.add(word);
                } else {
                    seen.add(word);
                }
            }
        }
        
        return new ArrayList<>(repeating);
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== Repeating Words Finder ===");
        System.out.println("Finds words that appear more than once in a sentence");
        
        System.out.print("\nEnter text: ");
        String input = scanner.nextLine();
        List<String> repeatingWords = findRepeatingWords(input);
        
        System.out.println("\nRepeating words:");
        if (repeatingWords.isEmpty()) {
            System.out.println("No repeating words found.");
        } else {
            System.out.println(String.join(", ", repeatingWords));
        }
        
        // Test with example
        System.out.println("\n--- Example Test ---");
        String exampleText = "This is is a repeated repeated word test.";
        System.out.println("Input: " + exampleText);
        System.out.println("Output: " + String.join(", ", findRepeatingWords(exampleText)));
        
        scanner.close();
    }
}