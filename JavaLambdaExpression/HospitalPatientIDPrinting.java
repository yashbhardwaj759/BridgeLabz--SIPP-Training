import java.util.*;
import java.util.function.Consumer;

// Patient class representing a hospital patient
class Patient {
    private String patientId;
    private String name;
    private int age;
    private String department;
    
    public Patient(String patientId, String name, int age, String department) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
        this.department = department;
    }
    
    public String getPatientId() { return patientId; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getDepartment() { return department; }
    
    // Method to be used with method reference
    public void printPatientId() {
        System.out.println("Patient ID: " + patientId + " - " + name);
    }
    
    @Override
    public String toString() {
        return String.format("ID: %-8s | Name: %-15s | Age: %2d | Dept: %s", 
                           patientId, name, age, department);
    }
}

// Hospital management system
class HospitalSystem {
    private List<Patient> patients;
    
    public HospitalSystem() {
        patients = new ArrayList<>();
        initializePatients();
    }
    
    private void initializePatients() {
        patients.add(new Patient("P001", "Alice Johnson", 45, "Cardiology"));
        patients.add(new Patient("P002", "Bob Smith", 32, "Neurology"));
        patients.add(new Patient("P003", "Carol Davis", 67, "Oncology"));
        patients.add(new Patient("P004", "David Wilson", 28, "Pediatrics"));
        patients.add(new Patient("P005", "Eva Brown", 54, "Orthopedics"));
        patients.add(new Patient("P006", "Frank Miller", 41, "Dermatology"));
        patients.add(new Patient("P007", "Grace Lee", 29, "Gynecology"));
        patients.add(new Patient("P008", "Henry Taylor", 73, "Geriatrics"));
    }
    
    // Method 1: Using method reference to print patient IDs
    public void printAllPatientIds() {
        System.out.println("=== All Patient IDs (Method Reference) ===");
        patients.forEach(Patient::printPatientId);
    }
    
    // Method 2: Using method reference to print patient IDs by department
    public void printPatientIdsByDepartment(String department) {
        System.out.println("\n=== Patient IDs in " + department + " ===");
        patients.stream()
                .filter(p -> p.getDepartment().equalsIgnoreCase(department))
                .forEach(Patient::printPatientId);
    }
    
    // Method 3: Using method reference with Consumer
    public void printFormattedPatientIds(Consumer<Patient> printer) {
        System.out.println("\n=== Formatted Patient IDs ===");
        patients.forEach(printer);
    }
    
    // Method 4: Static method reference for ID validation
    public static void validateAndPrintId(Patient patient) {
        String id = patient.getPatientId();
        if (id.matches("P\\d{3}")) {
            System.out.println("Valid ID: " + id + " - " + patient.getName());
        } else {
            System.out.println("Invalid ID: " + id);
        }
    }
    
    // Method 5: Using method reference to extract just IDs
    public List<String> getAllPatientIds() {
        return patients.stream()
                      .map(Patient::getPatientId)
                      .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
    }
    
    // Method 6: Using method reference for sorting by ID
    public void printSortedPatientIds() {
        System.out.println("\n=== Sorted Patient IDs ===");
        patients.stream()
                .sorted(Comparator.comparing(Patient::getPatientId))
                .forEach(Patient::printPatientId);
    }
    
    public List<Patient> getPatients() {
        return new ArrayList<>(patients);
    }
}

public class HospitalPatientIDPrinting {
    public static void main(String[] args) {
        HospitalSystem hospital = new HospitalSystem();
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== Hospital Patient ID Printing System ===\n");
        
        // Demonstrate different ways to print patient IDs using method references
        
        // 1. Basic method reference
        hospital.printAllPatientIds();
        
        // 2. Filtered method reference
        hospital.printPatientIdsByDepartment("Cardiology");
        
        // 3. Custom formatter using method reference
        hospital.printFormattedPatientIds(Patient::printPatientId);
        
        // 4. Static method reference
        System.out.println("\n=== Validated Patient IDs ===");
        hospital.getPatients().forEach(HospitalSystem::validateAndPrintId);
        
        // 5. Extract and print IDs
        System.out.println("\n=== Extracted Patient IDs ===");
        List<String> ids = hospital.getAllPatientIds();
        ids.forEach(System.out::println);
        
        // 6. Sorted IDs
        hospital.printSortedPatientIds();
        
        // Interactive mode
        System.out.println("\n--- Interactive Mode ---");
        
        while (true) {
            System.out.println("\nOptions:");
            System.out.println("1. Print all patient IDs");
            System.out.println("2. Print IDs by department");
            System.out.println("3. Print sorted IDs");
            System.out.println("4. Print validated IDs");
            System.out.println("5. Print extracted ID list");
            System.out.println("6. Quit");
            
            System.out.print("Choose option: ");
            String choice = scanner.nextLine();
            
            switch (choice) {
                case "1":
                    hospital.printAllPatientIds();
                    break;
                    
                case "2":
                    System.out.print("Enter department: ");
                    String dept = scanner.nextLine();
                    hospital.printPatientIdsByDepartment(dept);
                    break;
                    
                case "3":
                    hospital.printSortedPatientIds();
                    break;
                    
                case "4":
                    System.out.println("=== Validated Patient IDs ===");
                    hospital.getPatients().forEach(HospitalSystem::validateAndPrintId);
                    break;
                    
                case "5":
                    List<String> patientIds = hospital.getAllPatientIds();
                    System.out.println("Patient ID List: " + patientIds);
                    break;
                    
                case "6":
                    scanner.close();
                    System.out.println("Hospital system shutting down...");
                    return;
                    
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}