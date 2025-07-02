// Superclass: Vehicle
class Vehicle {
    protected int maxSpeed;
    protected String model;

    public Vehicle(int maxSpeed, String model) {
        this.maxSpeed = maxSpeed;
        this.model = model;
    }

    public void displayInfo() {
        System.out.println("Model: " + model);
        System.out.println("Max Speed: " + maxSpeed + " km/h");
    }
}

// Interface: Refuelable
interface Refuelable {
    void refuel();
}

// Subclass: PetrolVehicle (inherits from Vehicle and implements Refuelable)
class PetrolVehicle extends Vehicle implements Refuelable {

    public PetrolVehicle(int maxSpeed, String model) {
        super(maxSpeed, model);
    }

    public void refuel() {
        System.out.println("Vehicle Type: Petrol Vehicle");
        displayInfo();
        System.out.println("Refueling petrol tank...");
        System.out.println();
    }
}

// Subclass: ElectricVehicle (inherits from Vehicle)
class ElectricVehicle extends Vehicle {

    public ElectricVehicle(int maxSpeed, String model) {
        super(maxSpeed, model);
    }

    public void charge() {
        System.out.println("Vehicle Type: Electric Vehicle");
        displayInfo();
        System.out.println("Charging electric battery...");
        System.out.println();
    }
}

// Main class to test
public class VehicleTest {
    public static void main(String[] args) {
        PetrolVehicle petrolCar = new PetrolVehicle(180, "Maruti Swift");
        ElectricVehicle electricCar = new ElectricVehicle(160, "Tata Nexon EV");

        petrolCar.refuel();
        electricCar.charge();
    }
}
