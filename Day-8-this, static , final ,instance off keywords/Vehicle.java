public class Vehicle {
    // Static variable
    private static double registrationFee = 100.0;
    private static int totalVehicles = 0;

    // Instance variables
    private String ownerName;
    private String vehicleType;
    private final String registrationNumber;

    // Constructor using this
    public Vehicle(String ownerName, String vehicleType, String registrationNumber) {
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
        this.registrationNumber = registrationNumber;
        totalVehicles++;
    }

    // Static method
    public static void updateRegistrationFee(double newFee) {
        registrationFee = newFee;
        System.out.println("Registration fee updated to: $" + registrationFee);
    }

    // Instance method with instanceof check
    public void displayDetails(Object obj) {
        if (obj instanceof Vehicle) {
            Vehicle vehicle = (Vehicle) obj;
            System.out.println("Vehicle Details:");
            System.out.println("Owner Name: " + vehicle.ownerName);
            System.out.println("Vehicle Type: " + vehicle.vehicleType);
            System.out.println("Registration Number: " + vehicle.registrationNumber);
            System.out.println("Registration Fee: $" + registrationFee);
        } else {
            System.out.println("Invalid object: Not a Vehicle instance");
        }
    }

    public static void main(String[] args) {
        Vehicle v1 = new Vehicle("Alice", "Car", "REG001");
        Vehicle v2 = new Vehicle("Bob", "Motorcycle", "REG002");
        v1.displayDetails(v1);
        Vehicle.updateRegistrationFee(150.0);
        v2.displayDetails(v2);
        v1.displayDetails(new String("Invalid"));
    }
}