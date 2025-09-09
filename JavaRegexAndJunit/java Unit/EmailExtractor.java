import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.ArrayList;
import java.util.List;

public class DateExtractor {
    private static final String DATE_PATTERN = "\\b(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/([0-9]{4})\\b";
    
    public static List<String> extractDates(String text) {
        List<String> dates = new ArrayList<>();
        Pattern pattern = Pattern.compile(DATE_PATTERN);
        Matcher matcher = pattern.matcher(text);
        
        while (matcher.find()) {
            dates.add(matcher.group());
        }
        
        return dates;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== Date Extractor (dd/mm/yyyy) ===");
        System.out.println("Enter text to extract dates from:");
        
        String input = scanner.nextLine();
        List<String> dates = extractDates(input);
        
        System.out.println("\nExtracted dates:");
        if (dates.isEmpty()) {
            System.out.println("No dates found in dd/mm/yyyy format.");
        } else {
            System.out.println(String.join(", ", dates));
        }
        
        // Test with example
        System.out.println("\n--- Example Test ---");
        String exampleText = "The events are scheduled for 12/05/2023, 15/08/2024, and 29/02/2020.";
        System.out.println("Input: " + exampleText);
        System.out.println("Output:");
        List<String> exampleDates = extractDates(exampleText);
        System.out.println(String.join(", ", exampleDates));
        
        scanner.close();
    }
}