import java.util.Scanner;
import java.util.regex.Pattern;

public class SpaceNormalizer {
    
    public static String normalizeSpaces(String text) {
        return text.replaceAll("\\s+", " ").trim();
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== Space Normalizer ===");
        System.out.println("Replaces multiple spaces with a single space");
        
        System.out.print("\nEnter text: ");
        String input = scanner.nextLine();
        
        String normalized = normalizeSpaces(input);
        
        System.out.println("\nOriginal: '" + input + "'");
        System.out.println("Normalized: '" + normalized + "'");
        
        // Test with example
        System.out.println("\n--- Example Test ---");
        String exampleText = "This    is   an    example   with   multiple   spaces.";
        System.out.println("Input: " + exampleText);
        System.out.println("Output: " + normalizeSpaces(exampleText));
        
        scanner.close();
    }
}