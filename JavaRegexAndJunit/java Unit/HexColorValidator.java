import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class HexColorValidator {
    private static final String HEX_COLOR_PATTERN = "^#[0-9A-Fa-f]{6}$";
    
    public static boolean isValidHexColor(String color) {
        Pattern pattern = Pattern.compile(HEX_COLOR_PATTERN);
        Matcher matcher = pattern.matcher(color);
        return matcher.matches();
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== Hex Color Code Validator ===");
        System.out.println("Format: # followed by 6 hexadecimal characters");
        System.out.println("Example: #FFA500, #ff4500");
        
        System.out.print("\nEnter hex color code: ");
        String color = scanner.nextLine();
        
        if (isValidHexColor(color)) {
            System.out.println("✅ Valid hex color code");
        } else {
            System.out.println("❌ Invalid hex color code format");
        }
        
        // Test examples
        System.out.println("\nTest Examples:");
        String[] testCases = {"#FFA500", "#ff4500", "#123", "#1234567", "#GGHHII", "#abcdef"};
        for (String test : testCases) {
            System.out.println(test + " → " + (isValidHexColor(test) ? "Valid" : "Invalid"));
        }
        
        scanner.close();
    }
}