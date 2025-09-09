import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

// Alert class representing a hospital notification
class Alert {
    public enum AlertType {
        MEDICATION_REMINDER, APPOINTMENT_REMINDER, EMERGENCY, TEST_RESULTS, VISITING_HOURS, GENERAL_INFO
    }
    
    public enum Priority {
        LOW, MEDIUM, HIGH, CRITICAL
    }
    
    private String patientId;
    private String message;
    private AlertType type;
    private Priority priority;
    private Date timestamp;
    private boolean isRead;
    
    public Alert(String patientId, String message, AlertType type, Priority priority) {
        this.patientId = patientId;
        this.message = message;
        this.type = type;
        this.priority = priority;
        this.timestamp = new Date();
        this.isRead = false;
    }
    
    // Getters
    public String getPatientId() { return patientId; }
    public String getMessage() { return message; }
    public AlertType getType() { return type; }
    public Priority getPriority() { return priority; }
    public Date getTimestamp() { return timestamp; }
    public boolean isRead() { return isRead; }
    
    public void markAsRead() { isRead = true; }
    
    @Override
    public String toString() {
        return String.format("[%s] %s - %s: %s",
                priority, type, new java.text.SimpleDateFormat("HH:mm").format(timestamp), message);
    }
}

// User preferences class
class UserPreferences {
    private Set<Alert.AlertType> allowedTypes;
    private Set<Alert.Priority> allowedPriorities;
    private boolean showReadAlerts;
    
    public UserPreferences() {
        allowedTypes = new HashSet<>();
        allowedPriorities = new HashSet<>();
        showReadAlerts = false;
    }
    
    public void addAllowedType(Alert.AlertType type) {
        allowedTypes.add(type);
    }
    
    public void removeAllowedType(Alert.AlertType type) {
        allowedTypes.remove(type);
    }
    
    public void addAllowedPriority(Alert.Priority priority) {
        allowedPriorities.add(priority);
    }
    
    public void removeAllowedPriority(Alert.Priority priority) {
        allowedPriorities.remove(priority);
    }
    
    public void setShowReadAlerts(boolean show) {
        showReadAlerts = show;
    }
    
    public Set<Alert.AlertType> getAllowedTypes() { return allowedTypes; }
    public Set<Alert.Priority> getAllowedPriorities() { return allowedPriorities; }
    public boolean getShowReadAlerts() { return showReadAlerts; }
}

// Notification manager class
class NotificationManager {
    private List<Alert> alerts;
    private Map<String, UserPreferences> userPreferences;
    
    public NotificationManager() {
        alerts = new ArrayList<>();
        userPreferences = new HashMap<>();
        initializeSampleAlerts();
    }
    
    private void initializeSampleAlerts() {
        alerts.add(new Alert("P001", "Time to take your blood pressure medication", 
                           Alert.AlertType.MEDICATION_REMINDER, Alert.Priority.HIGH));
        alerts.add(new Alert("P001", "Your blood test results are ready", 
                           Alert.AlertType.TEST_RESULTS, Alert.Priority.MEDIUM));
        alerts.add(new Alert("P002", "Doctor appointment tomorrow at 2 PM", 
                           Alert.AlertType.APPOINTMENT_REMINDER, Alert.Priority.MEDIUM));
        alerts.add(new Alert("P003", "CODE BLUE - Emergency in Room 205", 
                           Alert.AlertType.EMERGENCY, Alert.Priority.CRITICAL));
        alerts.add(new Alert("P001", "Visiting hours are from 9 AM to 8 PM", 
                           Alert.AlertType.VISITING_HOURS, Alert.Priority.LOW));
        alerts.add(new Alert("P002", "Flu vaccination available", 
                           Alert.AlertType.GENERAL_INFO, Alert.Priority.LOW));
    }
    
    public void addAlert(Alert alert) {
        alerts.add(alert);
    }
    
    public void setUserPreferences(String patientId, UserPreferences preferences) {
        userPreferences.put(patientId, preferences);
    }
    
    // Filter alerts using lambda expressions with Predicate
    public List<Alert> filterAlerts(String patientId) {
        UserPreferences preferences = userPreferences.get(patientId);
        final UserPreferences finalPreferences;
        
        if (preferences == null) {
            finalPreferences = new UserPreferences(); // Default preferences
            // Enable all types and priorities by default
            finalPreferences.addAllowedType(Alert.AlertType.MEDICATION_REMINDER);
            finalPreferences.addAllowedType(Alert.AlertType.APPOINTMENT_REMINDER);
            finalPreferences.addAllowedType(Alert.AlertType.EMERGENCY);
            finalPreferences.addAllowedPriority(Alert.Priority.HIGH);
            finalPreferences.addAllowedPriority(Alert.Priority.CRITICAL);
        } else {
            finalPreferences = preferences;
        }
        
        // Create predicates using lambdas
        Predicate<Alert> typeFilter = alert -> 
            finalPreferences.getAllowedTypes().isEmpty() || 
            finalPreferences.getAllowedTypes().contains(alert.getType());
            
        Predicate<Alert> priorityFilter = alert -> 
            finalPreferences.getAllowedPriorities().isEmpty() || 
            finalPreferences.getAllowedPriorities().contains(alert.getPriority());
            
        Predicate<Alert> readFilter = alert -> 
            finalPreferences.getShowReadAlerts() || !alert.isRead();
            
        Predicate<Alert> patientFilter = alert -> 
            alert.getPatientId().equals(patientId);
        
        // Combine all predicates
        return alerts.stream()
                .filter(patientFilter)
                .filter(typeFilter)
                .filter(priorityFilter)
                .filter(readFilter)
                .sorted(Comparator.comparing(Alert::getPriority).reversed()
                        .thenComparing(Alert::getTimestamp))
                .collect(Collectors.toList());
    }
    
    // Advanced filtering methods using lambdas
    public List<Alert> getCriticalAlerts(String patientId) {
        return alerts.stream()
                .filter(alert -> alert.getPatientId().equals(patientId))
                .filter(alert -> alert.getPriority() == Alert.Priority.CRITICAL)
                .collect(Collectors.toList());
    }
    
    public List<Alert> getUnreadAlerts(String patientId) {
        return alerts.stream()
                .filter(alert -> alert.getPatientId().equals(patientId))
                .filter(alert -> !alert.isRead())
                .collect(Collectors.toList());
    }
    
    public long getAlertCount(String patientId, Alert.AlertType type) {
        return alerts.stream()
                .filter(alert -> alert.getPatientId().equals(patientId))
                .filter(alert -> alert.getType() == type)
                .count();
    }
    
    public void markAlertAsRead(String patientId, int index) {
        List<Alert> patientAlerts = filterAlerts(patientId);
        if (index >= 0 && index < patientAlerts.size()) {
            patientAlerts.get(index).markAsRead();
        }
    }
}

public class NotificationFiltering {
    public static void main(String[] args) {
        NotificationManager manager = new NotificationManager();
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== Hospital Notification Filtering System ===\n");
        
        // Set up preferences for patients
        UserPreferences p1Prefs = new UserPreferences();
        p1Prefs.addAllowedType(Alert.AlertType.MEDICATION_REMINDER);
        p1Prefs.addAllowedType(Alert.AlertType.TEST_RESULTS);
        p1Prefs.addAllowedPriority(Alert.Priority.HIGH);
        p1Prefs.addAllowedPriority(Alert.Priority.CRITICAL);
        
        manager.setUserPreferences("P001", p1Prefs);
        
        // Demonstrate filtering
        System.out.println("--- Patient P001 Notifications ---");
        List<Alert> filteredAlerts = manager.filterAlerts("P001");
        filteredAlerts.forEach(System.out::println);
        
        System.out.println("\n--- Critical Alerts for P001 ---");
        manager.getCriticalAlerts("P001").forEach(System.out::println);
        
        // Interactive mode
        System.out.println("\n--- Interactive Mode ---");
        
        while (true) {
            System.out.print("\nEnter patient ID (or 'quit' to exit): ");
            String patientId = scanner.nextLine();
            
            if (patientId.equalsIgnoreCase("quit")) break;
            
            System.out.println("\nAvailable options:");
            System.out.println("1. View all notifications");
            System.out.println("2. View critical alerts");
            System.out.println("3. View unread alerts");
            System.out.println("4. Mark alert as read");
            System.out.println("5. Set preferences");
            
            System.out.print("Choose option: ");
            String choice = scanner.nextLine();
            
            switch (choice) {
                case "1":
                    List<Alert> alerts = manager.filterAlerts(patientId);
                    if (alerts.isEmpty()) {
                        System.out.println("No notifications for patient " + patientId);
                    } else {
                        alerts.forEach(System.out::println);
                    }
                    break;
                    
                case "2":
                    List<Alert> critical = manager.getCriticalAlerts(patientId);
                    if (critical.isEmpty()) {
                        System.out.println("No critical alerts for patient " + patientId);
                    } else {
                        critical.forEach(System.out::println);
                    }
                    break;
                    
                case "3":
                    List<Alert> unread = manager.getUnreadAlerts(patientId);
                    if (unread.isEmpty()) {
                        System.out.println("No unread alerts for patient " + patientId);
                    } else {
                        unread.forEach(System.out::println);
                    }
                    break;
                    
                case "4":
                    List<Alert> allAlerts = manager.filterAlerts(patientId);
                    if (allAlerts.isEmpty()) {
                        System.out.println("No alerts to mark as read");
                        break;
                    }
                    
                    for (int i = 0; i < allAlerts.size(); i++) {
                        System.out.println(i + ": " + allAlerts.get(i));
                    }
                    System.out.print("Enter alert number to mark as read: ");
                    try {
                        int index = Integer.parseInt(scanner.nextLine());
                        manager.markAlertAsRead(patientId, index);
                        System.out.println("Alert marked as read!");
                    } catch (Exception e) {
                        System.out.println("Invalid input");
                    }
                    break;
                    
                case "5":
                    System.out.println("Preference setting coming soon...");
                    break;
                    
                default:
                    System.out.println("Invalid option");
            }
        }
        
        scanner.close();
        System.out.println("Notification system shutting down...");
    }
}