package Day5_JavaMethods;
import java.util.Scanner;
public class Q8 {
    public static double convertFahrenheitToCelsius(double f) {
        return (f - 32) * 5 / 9;
    }
    public static double convertCelsiusToFahrenheit(double c) {
        return (c * 9 / 5) + 32;
    }
    public static double convertPoundsToKilograms(double pounds) {
        return pounds * 0.453592;
    }
    public static double convertKilogramsToPounds(double kg) {
        return kg * 2.20462;
    }
    public static double convertGallonsToLiters(double gal) {
        return gal * 3.78541;
    }
    public static double convertLitersToGallons(double ltr) {
        return ltr * 0.264172;
    }
    public static void main(String[] args) {
        System.out.println("F to C: " + convertFahrenheitToCelsius(98.6));
        System.out.println("C to F: " + convertCelsiusToFahrenheit(37));
        System.out.println("Pounds to Kg: " + convertPoundsToKilograms(150));
        System.out.println("Kg to Pounds: " + convertKilogramsToPounds(68));
        System.out.println("Gallons to Liters: " + convertGallonsToLiters(5));
        System.out.println("Liters to Gallons: " + convertLitersToGallons(18.9));
    }
}
