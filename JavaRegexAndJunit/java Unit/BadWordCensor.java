import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.Arrays;
import java.util.List;

public class BadWordCensor {
    private static final List<String> BAD_WORDS = Arrays.asList("damn", "stupid", "fool", "idiot");
    
    public static String censorBadWords(String text, List<String> badWords) {
        String censoredText = text;
        
        for (String badWord : badWords) {
            String pattern = "\\b" + Pattern.quote(badWord) + "\\b";
            Pattern regex = Pattern.compile(pattern, Pattern.CASE_INSENSITIVE);
            Matcher matcher = regex.matcher(censoredText);
            censoredText = matcher.replaceAll("****");
        }
        
        return censoredText;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== Bad Word Censor ===");
        System.out.println("Censors bad words with ****");
        System.out.println("Default bad words: " + BAD_WORDS);
        
        System.out.print("\nEnter text: ");
        String input = scanner.nextLine();
        
        String censored = censorBadWords(input, BAD_WORDS);
        
        System.out.println("\nOriginal: " + input);
        System.out.println("Censored: " + censored);
        
        // Test with example
        System.out.println("\n--- Example Test ---");
        String exampleText = "This is a damn bad example with some stupid words.";
        System.out.println("Input: " + exampleText);
        System.out.println("Output: " + censorBadWords(exampleText, BAD_WORDS));
        
        scanner.close();
    }
}