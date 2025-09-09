
// Unit Conversion Tool
// Scenario: Logistics software needs standard unit conversions (km to miles, kg to lbs)
// Task: Implement conversions as static interface methods
// Package declaration removed since it should be in default package
// Unit conversion interface
interface UnitConverter {
    // Distance conversions
    static double kilometersToMiles(double kilometers) {
        return kilometers * 0.621371;
    }
    
    static double milesToKilometers(double miles) {
        return miles / 0.621371;
    }
    
    static double metersToFeet(double meters) {
        return meters * 3.28084;
    }
    
    static double feetToMeters(double feet) {
        return feet / 3.28084;
    }
    
    // Weight conversions
    static double kilogramsToPounds(double kilograms) {
        return kilograms * 2.20462;
    }
    
    static double poundsToKilograms(double pounds) {
        return pounds / 2.20462;
    }
    
    static double gramsToOunces(double grams) {
        return grams * 0.035274;
    }
    
    static double ouncesToGrams(double ounces) {
        return ounces / 0.035274;
    }
    
    // Volume conversions
    static double litersToGallons(double liters) {
        return liters * 0.264172;
    }
    
    static double gallonsToLiters(double gallons) {
        return gallons / 0.264172;
    }
    
    static double cubicMetersToCubicFeet(double cubicMeters) {
        return cubicMeters * 35.3147;
    }
    
    static double cubicFeetToCubicMeters(double cubicFeet) {
        return cubicFeet / 35.3147;
    }
    
    // Temperature conversions
    static double celsiusToFahrenheit(double celsius) {
        return (celsius * 9/5) + 32;
    }
    
    static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5/9;
    }
    
    // Logistics specific conversions
    static double kilogramsToTons(double kilograms) {
        return kilograms / 1000;
    }
    
    static double tonsToKilograms(double tons) {
        return tons * 1000;
    }
    
    static double kilometersToNauticalMiles(double kilometers) {
        return kilometers * 0.539957;
    }
    
    static double nauticalMilesToKilometers(double nauticalMiles) {
        return nauticalMiles / 0.539957;
    }
    
    // Utility method to format results
    static String formatResult(double value, String fromUnit, double converted, String toUnit) {
        return String.format("%.2f %s = %.2f %s", value, fromUnit, converted, toUnit);
    }
}

// Logistics shipment class
class Shipment {
    private String trackingNumber;
    private double weightKg;
    private double distanceKm;
    private double volumeM3;
    private double temperatureC;
    
    public Shipment(String trackingNumber, double weightKg, double distanceKm, double volumeM3, double temperatureC) {
        this.trackingNumber = trackingNumber;
        this.weightKg = weightKg;
        this.distanceKm = distanceKm;
        this.volumeM3 = volumeM3;
        this.temperatureC = temperatureC;
    }
    
    public void displayInMetric() {
        System.out.println("\n--- Shipment Details (Metric) ---");
        System.out.println("Tracking: " + trackingNumber);
        System.out.println("Weight: " + weightKg + " kg");
        System.out.println("Distance: " + distanceKm + " km");
        System.out.println("Volume: " + volumeM3 + " m³");
        System.out.println("Temperature: " + temperatureC + " °C");
    }
    
    public void displayInImperial() {
        System.out.println("\n--- Shipment Details (Imperial) ---");
        System.out.println("Tracking: " + trackingNumber);
        System.out.println("Weight: " + UnitConverter.formatResult(weightKg, "kg", UnitConverter.kilogramsToPounds(weightKg), "lbs"));
        System.out.println("Distance: " + UnitConverter.formatResult(distanceKm, "km", UnitConverter.kilometersToMiles(distanceKm), "miles"));
        System.out.println("Volume: " + UnitConverter.formatResult(volumeM3, "m³", UnitConverter.cubicMetersToCubicFeet(volumeM3), "ft³"));
        System.out.println("Temperature: " + UnitConverter.formatResult(temperatureC, "°C", UnitConverter.celsiusToFahrenheit(temperatureC), "°F"));
    }
    
    public double calculateShippingCost(double ratePerKg, double ratePerKm) {
        return (weightKg * ratePerKg) + (distanceKm * ratePerKm);
    }
}

// Logistics calculator class
class LogisticsCalculator {
    public static void calculateFuelEfficiency(double distanceKm, double fuelLiters) {
        double efficiencyKmPerLiter = distanceKm / fuelLiters;
        double efficiencyMilesPerGallon = UnitConverter.kilometersToMiles(distanceKm) / UnitConverter.litersToGallons(fuelLiters);
        
        System.out.println("\n--- Fuel Efficiency ---");
        System.out.println(UnitConverter.formatResult(efficiencyKmPerLiter, "km/l", efficiencyMilesPerGallon, "miles/gallon"));
    }
    
    public static void calculateCargoCapacity(double maxWeightKg, double maxVolumeM3) {
        System.out.println("\n--- Cargo Capacity ---");
        System.out.println("Max Weight: " + UnitConverter.formatResult(maxWeightKg, "kg", UnitConverter.kilogramsToTons(maxWeightKg), "tons"));
        System.out.println("Max Volume: " + UnitConverter.formatResult(maxVolumeM3, "m³", UnitConverter.cubicMetersToCubicFeet(maxVolumeM3), "ft³"));
    }
}

// Unit conversion demo
public class UnitConversionTool {
    public static void main(String[] args) {
        System.out.println("=== Unit Conversion Tool for Logistics ===\n");
        
        // Display conversion examples
        System.out.println("--- Distance Conversions ---");
        System.out.println(UnitConverter.formatResult(100, "km", UnitConverter.kilometersToMiles(100), "miles"));
        System.out.println(UnitConverter.formatResult(62.14, "miles", UnitConverter.milesToKilometers(62.14), "km"));
        System.out.println(UnitConverter.formatResult(1000, "m", UnitConverter.metersToFeet(1000), "feet"));
        
        System.out.println("\n--- Weight Conversions ---");
        System.out.println(UnitConverter.formatResult(1000, "kg", UnitConverter.kilogramsToPounds(1000), "lbs"));
        System.out.println(UnitConverter.formatResult(500, "lbs", UnitConverter.poundsToKilograms(500), "kg"));
        System.out.println(UnitConverter.formatResult(100, "grams", UnitConverter.gramsToOunces(100), "oz"));
        
        System.out.println("\n--- Volume Conversions ---");
        System.out.println(UnitConverter.formatResult(100, "liters", UnitConverter.litersToGallons(100), "gallons"));
        System.out.println(UnitConverter.formatResult(50, "gallons", UnitConverter.gallonsToLiters(50), "liters"));
        
        System.out.println("\n--- Temperature Conversions ---");
        System.out.println(UnitConverter.formatResult(0, "°C", UnitConverter.celsiusToFahrenheit(0), "°F"));
        System.out.println(UnitConverter.formatResult(32, "°F", UnitConverter.fahrenheitToCelsius(32), "°C"));
        System.out.println(UnitConverter.formatResult(100, "°C", UnitConverter.celsiusToFahrenheit(100), "°F"));
        
        System.out.println("\n--- Logistics Specific ---");
        System.out.println(UnitConverter.formatResult(5000, "kg", UnitConverter.kilogramsToTons(5000), "tons"));
        System.out.println(UnitConverter.formatResult(100, "nautical miles", UnitConverter.nauticalMilesToKilometers(100), "km"));
        
        // Create and display shipment details
        Shipment shipment1 = new Shipment("SHP001", 2500.5, 1500.75, 12.5, -5.0);
        Shipment shipment2 = new Shipment("SHP002", 5000.0, 2500.0, 25.0, 15.5);
        
        shipment1.displayInMetric();
        shipment1.displayInImperial();
        
        System.out.println("\n--- Shipping Cost Calculation ---");
        double cost = shipment1.calculateShippingCost(0.5, 0.2); // $0.5 per kg, $0.2 per km
        System.out.println("Shipping cost for SHP001: $" + String.format("%.2f", cost));
        
        shipment2.displayInMetric();
        shipment2.displayInImperial();
        
        // Calculate fuel efficiency
        System.out.println("\n--- Fuel Efficiency Calculation ---");
        LogisticsCalculator.calculateFuelEfficiency(1000, 100);
        
        // Calculate cargo capacity
        System.out.println("\n--- Cargo Capacity Calculation ---");
        LogisticsCalculator.calculateCargoCapacity(10000, 50);
        
        System.out.println("\n=== Unit Conversion Tool Demo Complete ===");
    }
}