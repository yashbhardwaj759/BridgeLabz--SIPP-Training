public class Patient {
    // Static variable
    private static String hospitalName = "City Hospital";
    private static int totalPatients = 0;

    // Instance variables
    private String name;
    private int age;
    private String ailment;
    private final String patientID;

    // Constructor using this
    public Patient(String name, int age, String ailment, String patientID) {
        this.name = name;
        this.age = age;
        this.ailment = ailment;
        this.patientID = patientID;
        totalPatients++;
    }

    // Static method
    public static void getTotalPatients() {
        System.out.println("Total Patients in " + hospitalName + ": " + totalPatients);
    }

    // Instance method with instanceof check
    public void displayDetails(Object obj) {
        if (obj instanceof Patient) {
            Patient patient = (Patient) obj;
            System.out.println("Patient Details:");
            System.out.println("Hospital: " + hospitalName);
            System.out.println("Name: " + patient.name);
            System.out.println("Age: " + patient.age);
            System.out.println("Ailment: " + patient.ailment);
            System.out.println("Patient ID: " + patient.patientID);
        } else {
            System.out.println("Invalid object: Not a Patient instance");
        }
    }

    public static void main(String[] args) {
        Patient p1 = new Patient("Alice", 30, "Flu", "PID001");
        Patient p2 = new Patient("Bob", 45, "Fracture", "PID002");
        p1.displayDetails(p1);
        p2.displayDetails(p2);
        Patient.getTotalPatients();
        p1.displayDetails(new String("Invalid"));
    }
}