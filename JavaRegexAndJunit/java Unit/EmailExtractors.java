import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.ArrayList;
import java.util.List;

public class EmailExtractor {
    private static final String EMAIL_PATTERN = "[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}";
    
    public static List<String> extractEmails(String text) {
        List<String> emails = new ArrayList<>();
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(text);
        
        while (matcher.find()) {
            emails.add(matcher.group());
        }
        
        return emails;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== Email Address Extractor ===");
        System.out.println("Enter text to extract email addresses from:");
        
        String input = scanner.nextLine();
        List<String> emails = extractEmails(input);
        
        System.out.println("\nExtracted email addresses:");
        if (emails.isEmpty()) {
            System.out.println("No email addresses found.");
        } else {
            for (String email : emails) {
                System.out.println(email);
            }
        }
        
        // Test with example
        System.out.println("\n--- Example Test ---");
        String exampleText = "Contact us at support@example.com and info@company.org";
        System.out.println("Input: " + exampleText);
        System.out.println("Output:");
        List<String> exampleEmails = extractEmails(exampleText);
        for (String email : exampleEmails) {
            System.out.println(email);
        }
        
        scanner.close();
    }
}
