
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.ArrayList;
import java.util.List;

public class LinkExtractor {
    private static final String LINK_PATTERN = "https?://[^\\s]+";
    
    public static List<String> extractLinks(String text) {
        List<String> links = new ArrayList<>();
        Pattern pattern = Pattern.compile(LINK_PATTERN);
        Matcher matcher = pattern.matcher(text);
        
        while (matcher.find()) {
            String link = matcher.group();
            // Remove trailing punctuation if any
            link = link.replaceAll("[.,;:!?]$", "");
            links.add(link);
        }
        
        return links;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== Link Extractor ===");
        System.out.println("Enter text to extract links from:");
        
        String input = scanner.nextLine();
        List<String> links = extractLinks(input);
        
        System.out.println("\nExtracted links:");
        if (links.isEmpty()) {
            System.out.println("No links found.");
        } else {
            for (String link : links) {
                System.out.println(link);
            }
        }
        
        // Test with example
        System.out.println("\n--- Example Test ---");
        String exampleText = "Visit https://www.google.com and http://example.org for more info.";
        System.out.println("Input: " + exampleText);
        System.out.println("Output:");
        List<String> exampleLinks = extractLinks(exampleText);
        for (String link : exampleLinks) {
            System.out.println(link);
        }
        
        scanner.close();
    }
}
