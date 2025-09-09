import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class UsernameValidator {
    private static final String USERNAME_PATTERN = "^[a-zA-Z][a-zA-Z0-9_]{4,14}$";
    
    public static boolean isValidUsername(String username) {
        Pattern pattern = Pattern.compile(USERNAME_PATTERN);
        Matcher matcher = pattern.matcher(username);
        return matcher.matches();
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== Username Validator ===");
        System.out.println("Rules:");
        System.out.println("- Only letters, numbers, and underscores");
        System.out.println("- Must start with a letter");
        System.out.println("- Must be 5-15 characters long");
        
        System.out.print("\nEnter username: ");
        String username = scanner.nextLine();
        
        if (isValidUsername(username)) {
            System.out.println("✅ Valid username");
        } else {
            System.out.println("❌ Invalid username");
        }
        
        // Test examples
        System.out.println("\nTest Examples:");
        String[] testCases = {"user_123", "123user", "us", "valid_user", "a_", "A12345678901234"};
        for (String test : testCases) {
            System.out.println(test + " → " + (isValidUsername(test) ? "Valid" : "Invalid"));
        }
        
        scanner.close();
    }
}