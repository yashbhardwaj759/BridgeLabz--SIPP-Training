import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class LicensePlateValidator {
    private static final String LICENSE_PLATE_PATTERN = "^[A-Z]{2}\\d{4}$";
    
    
    public static boolean isValidLicensePlate(String plate) {
        Pattern pattern = Pattern.compile(LICENSE_PLATE_PATTERN);
        Matcher matcher = pattern.matcher(plate);
        return matcher.matches();
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== License Plate Validator ===");
        System.out.println("Format: Two uppercase letters followed by four digits");
        System.out.println("Example: AB1234");
        
        System.out.print("\nEnter license plate: ");
        String plate = scanner.nextLine();
        
        if (isValidLicensePlate(plate)) {
            System.out.println("✅ Valid license plate");
        } else {
            System.out.println("❌ Invalid license plate format");
        }
        
        // Test examples
        System.out.println("\nTest Examples:");
        String[] testCases = {"AB1234", "A12345", "ABCD123", "12AB34", "XY0000", "ZZ9999"};
        for (String test : testCases) {
            System.out.println(test + " → " + (isValidLicensePlate(test) ? "Valid" : "Invalid"));
        }
        
        scanner.close();
    }
}