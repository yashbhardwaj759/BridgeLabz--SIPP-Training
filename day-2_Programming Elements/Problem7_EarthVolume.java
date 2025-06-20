public class Problem7_EarthVolume {
    public static void main(String[] args) {
        // Earth's radius in kilometers
        double radius = 6378;
        
        // Calculate volume in cubic kilometers
        double volumeKm = (4.0/3.0) * Math.PI * Math.pow(radius, 3);
        
        // Convert to cubic miles (1 km = 0.621371 miles)
        double volumeMiles = volumeKm * Math.pow(0.621371, 3);
        
        // Display results
        System.out.println("The volume of earth in cubic kilometers is " + volumeKm + 
                         " and cubic miles is " + volumeMiles);
    }
} 