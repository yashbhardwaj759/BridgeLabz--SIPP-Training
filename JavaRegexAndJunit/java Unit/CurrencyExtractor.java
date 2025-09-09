import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.ArrayList;
import java.util.List;

public class CurrencyExtractor {
    private static final String CURRENCY_PATTERN = "\\$[0-9]+(?:\\.[0-9]{2})?|[0-9]+\\.[0-9]{2}";
    
    public static List<String> extractCurrencyValues(String text) {
        List<String> currencies = new ArrayList<>();
        Pattern pattern = Pattern.compile(CURRENCY_PATTERN);
        Matcher matcher = pattern.matcher(text);
        
        while (matcher.find()) {
            currencies.add(matcher.group());
        }
        
        return currencies;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== Currency Value Extractor ===");
        System.out.println("Extracts currency values like $45.99 or 10.50");
        
        System.out.print("\nEnter text: ");
        String input = scanner.nextLine();
        List<String> currencies = extractCurrencyValues(input);
        
        System.out.println("\nExtracted currency values:");
        if (currencies.isEmpty()) {
            System.out.println("No currency values found.");
        } else {
            System.out.println(String.join(", ", currencies));
        }
        
        // Test with example
        System.out.println("\n--- Example Test ---");
        String exampleText = "The price is $45.99, and the discount is 10.50.";
        System.out.println("Input: " + exampleText);
        System.out.println("Output:");
        List<String> exampleCurrencies = extractCurrencyValues(exampleText);
        System.out.println(String.join(", ", exampleCurrencies));
        
        scanner.close();
    }
}