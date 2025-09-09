// String Length Checker
// Scenario: Check if a message exceeds character limit
// Task: Use Function<String, Integer>

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

// Message class
class Message {
    private String content;
    private String sender;
    private String timestamp;
    
    public Message(String content, String sender, String timestamp) {
        this.content = content;
        this.sender = sender;
        this.timestamp = timestamp;
    }
    
    public String getContent() {
        return content;
    }
    
    public String getSender() {
        return sender;
    }
    
    public String getTimestamp() {
        return timestamp;
    }
    
    @Override
    public String toString() {
        return "Message [sender=" + sender + ", length=" + content.length() + ", content=" + content.substring(0, Math.min(20, content.length())) + "...]";
    }
}

// String length checker system
class StringLengthChecker {
    private List<Message> messages;
    
    public StringLengthChecker() {
        this.messages = new ArrayList<>();
    }
    
    public void addMessage(Message message) {
        messages.add(message);
    }
    
    // Function to get string length
    public Function<String, Integer> getLengthFunction() {
        return String::length;
    }
    
    // Check if message exceeds limit
    public List<Message> getMessagesExceedingLimit(int limit) {
        List<Message> longMessages = new ArrayList<>();
        Function<String, Integer> lengthFunction = getLengthFunction();
        
        for (Message message : messages) {
            int length = lengthFunction.apply(message.getContent());
            if (length > limit) {
                longMessages.add(message);
            }
        }
        return longMessages;
    }
    
    // Get message statistics
    public void displayMessageStats(int limit) {
        Function<String, Integer> lengthFunction = getLengthFunction();
        
        System.out.println("\n--- Message Statistics ---");
        System.out.println("Total messages: " + messages.size());
        
        int exceedingCount = 0;
        int totalLength = 0;
        
        for (Message message : messages) {
            int length = lengthFunction.apply(message.getContent());
            totalLength += length;
            if (length > limit) {
                exceedingCount++;
            }
        }
        
        System.out.println("Messages exceeding " + limit + " characters: " + exceedingCount);
        System.out.println("Average message length: " + (messages.size() > 0 ? totalLength / messages.size() : 0));
    }
    
    // Custom length analysis
    public void analyzeMessages(Function<String, Integer> customLengthFunction, int limit) {
        System.out.println("\n--- Custom Length Analysis ---");
        for (Message message : messages) {
            int length = customLengthFunction.apply(message.getContent());
            if (length > limit) {
                System.out.println("Message from " + message.getSender() + " exceeds limit: " + length + " characters");
            }
        }
    }
    
    public void displayAllMessages() {
        System.out.println("\n--- All Messages ---");
        messages.forEach(System.out::println);
    }
}

// Social media platform class
class SocialMediaPlatform {
    private String platformName;
    private int characterLimit;
    private StringLengthChecker checker;
    
    public SocialMediaPlatform(String platformName, int characterLimit) {
        this.platformName = platformName;
        this.characterLimit = characterLimit;
        this.checker = new StringLengthChecker();
    }
    
    public void postMessage(String content, String sender) {
        String timestamp = java.time.LocalDateTime.now().toString();
        Message message = new Message(content, sender, timestamp);
        
        Function<String, Integer> lengthFunction = String::length;
        int length = lengthFunction.apply(content);
        
        if (length <= characterLimit) {
            checker.addMessage(message);
            System.out.println("Message posted successfully on " + platformName);
        } else {
            System.out.println("Message exceeds " + platformName + " character limit of " + characterLimit);
            System.out.println("Current length: " + length + " characters");
        }
    }
    
    public void displayPlatformStats() {
        System.out.println("\n=== " + platformName + " Stats ===");
        checker.displayMessageStats(characterLimit);
    }
}

public class StringLengthCheckerDemo {
    public static void main(String[] args) {
        System.out.println("=== String Length Checker Demo ===\n");
        
        // Create string length checker
        StringLengthChecker checker = new StringLengthChecker();
        
        // Create social media platforms with different limits
        SocialMediaPlatform twitter = new SocialMediaPlatform("Twitter", 280);
        SocialMediaPlatform facebook = new SocialMediaPlatform("Facebook", 500);
        SocialMediaPlatform linkedin = new SocialMediaPlatform("LinkedIn", 3000);
        
        // Post messages
        twitter.postMessage("Hello everyone! This is a short tweet.", "Alice");
        twitter.postMessage("This is a very long message that should definitely exceed the Twitter character limit of 280 characters because it contains way too much text and will trigger the character limit warning system", "Bob");
        
        facebook.postMessage("Facebook allows longer posts so this message should be fine even though it's longer than a tweet would allow.", "Charlie");
        facebook.postMessage("This is another Facebook post with more detailed content that users can share with their friends and family on the social media platform.", "Diana");
        
        linkedin.postMessage("LinkedIn professional networking platform allows for much longer posts and articles that can contain detailed professional insights and career updates.", "Eve");
        
        // Add some messages directly to checker for analysis
        checker.addMessage(new Message("Short message", "User1", "2024-01-01 10:00"));
        checker.addMessage(new Message("This is a medium length message that should be fine for most platforms", "User2", "2024-01-01 11:00"));
        checker.addMessage(new Message("This is a very long message that definitely exceeds most character limits and should be flagged as too long for typical social media posts", "User3", "2024-01-01 12:00"));
        
        // Display all messages
        checker.displayAllMessages();
        
        // Check for messages exceeding limit
        System.out.println("\n--- Messages Exceeding 50 Characters ---");
        List<Message> longMessages = checker.getMessagesExceedingLimit(50);
        longMessages.forEach(msg -> 
            System.out.println("Long message: " + msg.getSender() + " - " + msg.getContent().length() + " characters"));
        
        // Display statistics
        checker.displayMessageStats(50);
        
        // Custom analysis
        System.out.println("\n--- Custom Analysis: Word Count ---");
        Function<String, Integer> wordCountFunction = str -> str.split("\\s+").length;
        checker.analyzeMessages(wordCountFunction, 10);
        
        // Platform-specific stats
        twitter.displayPlatformStats();
        facebook.displayPlatformStats();
        linkedin.displayPlatformStats();
        
        System.out.println("\n=== String Length Checker Demo Complete ===");
    }
}