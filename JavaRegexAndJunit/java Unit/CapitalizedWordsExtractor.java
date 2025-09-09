package JavaRegexAndJunit.java Unit;

public import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.ArrayList;
import java.util.List;

public class CapitalizedWordsExtractor {
    private static final String CAPITALIZED_WORD_PATTERN = "\\b[A-Z][a-zA-Z]*\\b";
    
    public static List<String> extractCapitalizedWords(String text) {
        List<String> words = new ArrayList<>();
        Pattern pattern = Pattern.compile(CAPITALIZED_WORD_PATTERN);
        Matcher matcher = pattern.matcher(text);
        
        while (matcher.find()) {
            words.add(matcher.group());
        }
        
        return words;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== Capitalized Words Extractor ===");
        System.out.println("Enter text to extract capitalized words from:");
        
        String input = scanner.nextLine();
        List<String> words = extractCapitalizedWords(input);
        
        System.out.println("\nExtracted capitalized words:");
        if (words.isEmpty()) {
            System.out.println("No capitalized words found.");
        } else {
            System.out.println(String.join(", ", words));
        }
        
        // Test with example
        System.out.println("\n--- Example Test ---");
        String exampleText = "The Eiffel Tower is in Paris and the Statue of Liberty is in New York.";
        System.out.println("Input: " + exampleText);
        System.out.println("Output:");
        List<String> exampleWords = extractCapitalizedWords(exampleText);
        System.out.println(String.join(", ", exampleWords));
        
        scanner.close();
    }
} {
    
}
