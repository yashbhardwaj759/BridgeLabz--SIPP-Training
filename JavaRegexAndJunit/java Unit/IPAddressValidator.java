import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class IPAddressValidator {
    private static final String IP_PATTERN = 
        "^(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\." +
        "(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\." +
        "(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\." +
        "(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$";
    
    public static boolean isValidIPAddress(String ip) {
        Pattern pattern = Pattern.compile(IP_PATTERN);
        Matcher matcher = pattern.matcher(ip);
        return matcher.matches();
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== IPv4 Address Validator ===");
        System.out.println("Valid IPv4 format: Four groups of numbers (0-255) separated by dots");
        
        System.out.print("\nEnter IP address: ");
        String ip = scanner.nextLine();
        
        if (isValidIPAddress(ip)) {
            System.out.println("✅ Valid IPv4 address");
        } else {
            System.out.println("❌ Invalid IPv4 address format");
        }
        
        // Test examples
        System.out.println("\nTest Examples:");
        String[] testCases = {
            "192.168.1.1", "255.255.255.255", "0.0.0.0", 
            "256.1.1.1", "192.168.1", "192.168.1.1.1", "192.168.1.256"
        };
        for (String test : testCases) {
            System.out.println(test + " → " + (isValidIPAddress(test) ? "Valid" : "Invalid"));
        }
        
        scanner.close();
    }
}
