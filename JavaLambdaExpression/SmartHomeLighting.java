import java.util.*;
import java.util.function.*;

// Functional interface for light activation behavior
interface LightBehavior {
    void activate(String room);
}

// Light class representing a smart light
class SmartLight {
    private String room;
    private boolean isOn;
    
    public SmartLight(String room) {
        this.room = room;
        this.isOn = false;
    }
    
    public void turnOn() {
        isOn = true;
        System.out.println(room + " light is now ON");
    }
    
    public void turnOff() {
        isOn = false;
        System.out.println(room + " light is now OFF");
    }
    
    public void dimLight(int percentage) {
        System.out.println(room + " light dimmed to " + percentage + "%");
    }
    
    public void setColor(String color) {
        System.out.println(room + " light color changed to " + color);
    }
    
    public String getRoom() {
        return room;
    }
}

// Smart Home Controller
class SmartHomeController {
    private List<SmartLight> lights;
    private Map<String, LightBehavior> behaviors;
    
    public SmartHomeController() {
        lights = new ArrayList<>();
        behaviors = new HashMap<>();
        initializeLights();
        setupBehaviors();
    }
    
    private void initializeLights() {
        lights.add(new SmartLight("Living Room"));
        lights.add(new SmartLight("Bedroom"));
        lights.add(new SmartLight("Kitchen"));
        lights.add(new SmartLight("Bathroom"));
    }
    
    private void setupBehaviors() {
        // Motion detection behavior
        behaviors.put("motion", room -> {
            SmartLight light = findLight(room);
            if (light != null) {
                light.turnOn();
                light.dimLight(80);
            }
        });
        
        // Evening time behavior
        behaviors.put("evening", room -> {
            SmartLight light = findLight(room);
            if (light != null) {
                light.turnOn();
                light.setColor("warm white");
                light.dimLight(30);
            }
        });
        
        // Voice command behavior
        behaviors.put("voice_on", room -> {
            SmartLight light = findLight(room);
            if (light != null) {
                light.turnOn();
                light.setColor("bright white");
                light.dimLight(100);
            }
        });
        
        // Sleep mode behavior
        behaviors.put("sleep", room -> {
            SmartLight light = findLight(room);
            if (light != null) {
                light.setColor("red");
                light.dimLight(5);
            }
        });
        
        // Party mode behavior
        behaviors.put("party", room -> {
            SmartLight light = findLight(room);
            if (light != null) {
                light.turnOn();
                light.setColor("rainbow");
                System.out.println("Party mode activated in " + room);
            }
        });
    }
    
    private SmartLight findLight(String room) {
        return lights.stream()
                .filter(light -> light.getRoom().equalsIgnoreCase(room))
                .findFirst()
                .orElse(null);
    }
    
    public void triggerBehavior(String trigger, String room) {
        LightBehavior behavior = behaviors.get(trigger);
        if (behavior != null) {
            System.out.println("Trigger: " + trigger + " in " + room);
            behavior.activate(room);
        } else {
            System.out.println("Unknown trigger: " + trigger);
        }
    }
    
    public void addCustomBehavior(String name, LightBehavior behavior) {
        behaviors.put(name, behavior);
        System.out.println("Custom behavior '" + name + "' added!");
    }
}

public class SmartHomeLighting {
    public static void main(String[] args) {
        SmartHomeController controller = new SmartHomeController();
        
        System.out.println("=== Smart Home Lighting Automation ===\n");
        
        // Demonstrate different triggers
        controller.triggerBehavior("motion", "Living Room");
        controller.triggerBehavior("evening", "Bedroom");
        controller.triggerBehavior("voice_on", "Kitchen");
        controller.triggerBehavior("sleep", "Bedroom");
        controller.triggerBehavior("party", "Living Room");
        
        // Add a custom behavior using lambda
        System.out.println("\n--- Adding Custom Behavior ---");
        controller.addCustomBehavior("reading", room -> {
            SmartLight light = new SmartLight(""); // Temporary for demo
            System.out.println("Reading mode in " + room + " - soft blue light at 60% brightness");
        });
        
        controller.triggerBehavior("reading", "Study Room");
        
        // Interactive mode
        System.out.println("\n--- Interactive Mode ---");
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("\nAvailable triggers: motion, evening, voice_on, sleep, party, reading");
            System.out.print("Enter trigger and room (or 'quit' to exit): ");
            String input = scanner.nextLine();
            
            if (input.equalsIgnoreCase("quit")) break;
            
            String[] parts = input.split(" ");
            if (parts.length == 2) {
                controller.triggerBehavior(parts[0], parts[1]);
            } else {
                System.out.println("Please enter: trigger room_name");
            }
        }
        
        scanner.close();
        System.out.println("Smart home system shutting down...");
    }
}