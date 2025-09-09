import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ProgrammingLanguageExtractor {
    private static final Set<String> KNOWN_LANGUAGES = new HashSet<>(Arrays.asList(
        "Java", "Python", "JavaScript", "Go", "C++", "C#", "Ruby", "PHP", "Swift", "Kotlin",
        "TypeScript", "Rust", "Scala", "Perl", "R", "MATLAB", "Objective-C", "Dart", "Lua", "Haskell"
    ));
    
    public static List<String> extractProgrammingLanguages(String text) {
        List<String> languages = new ArrayList<>();
        
        // Pattern to match words starting with capital letter
        Pattern pattern = Pattern.compile("\\b[A-Z][a-zA-Z+#-]*\\b");
        Matcher matcher = pattern.matcher(text);
        
        while (matcher.find()) {
            String word = matcher.group();
            if (KNOWN_LANGUAGES.contains(word)) {
                if (!languages.contains(word)) {
                    languages.add(word);
                }
            }
        }
        
        return languages;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== Programming Language Extractor ===");
        System.out.println("Enter text to extract programming language names from:");
        
        String input = scanner.nextLine();
        List<String> languages = extractProgrammingLanguages(input);
        
        System.out.println("\nExtracted programming languages:");
        if (languages.isEmpty()) {
            System.out.println("No known programming languages found.");
        } else {
            System.out.println(String.join(", ", languages));
        }
        
        // Test with example
        System.out.println("\n--- Example Test ---");
        String exampleText = "I love Java, Python, and JavaScript, but I haven't tried Go yet.";
        System.out.println("Input: " + exampleText);
        System.out.println("Output:");
        List<String> exampleLanguages = extractProgrammingLanguages(exampleText);
        System.out.println(String.join(", ", exampleLanguages));
        
        scanner.close();
    }
}