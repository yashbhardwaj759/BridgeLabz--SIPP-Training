import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;

// Notification interface as a base contract
interface Notification {
    String getMessage();

    String getNotificationType();

    LocalDateTime getTimestamp();

    String formatNotification();
}

// Base abstract class implementing common functionality
abstract class AbstractNotification implements Notification {
    protected final String message;
    protected final LocalDateTime timestamp;

    public AbstractNotification(String message) {
        this.message = message;
        this.timestamp = LocalDateTime.now();
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    @Override
    public String formatNotification() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return String.format("[%s] %s - %s",
                getNotificationType(),
                timestamp.format(formatter),
                message);
    }
}

// Concrete notification classes
class LikeNotification extends AbstractNotification {
    public LikeNotification(String sender) {
        super(String.format("%s liked your post", sender));
    }

    @Override
    public String getNotificationType() {
        return "LIKE";
    }
}

class CommentNotification extends AbstractNotification {
    public CommentNotification(String sender) {
        super(String.format("%s commented on your post", sender));
    }

    @Override
    public String getNotificationType() {
        return "COMMENT";
    }
}

class FollowNotification extends AbstractNotification {
    public FollowNotification(String sender) {
        super(String.format("%s started following you", sender));
    }

    @Override
    public String getNotificationType() {
        return "FOLLOW";
    }
}

// Notification feed manager (uses LinkedList internally)
class NotificationFeed {
    private final LinkedList<Notification> notifications;

    public NotificationFeed() {
        this.notifications = new LinkedList<>();
    }

    public void addNotification(Notification notification) {
        notifications.addFirst(notification); // O(1) operation for LinkedList
    }

    public void displayNotifications() {
        System.out.println("\n=== NOTIFICATION FEED ===");
        System.out.println("(Most recent first)\n");

        if (notifications.isEmpty()) {
            System.out.println("No notifications yet");
            return;
        }

        notifications.forEach(n -> System.out.println(n.formatNotification()));
    }

    public int getUnreadCount() {
        return notifications.size();
    }

    public void clearNotifications() {
        notifications.clear();
    }
}

// Demo class
public class SocialMediaNotifications {
    public static void main(String[] args) {
        // Create notification feed
        NotificationFeed feed = new NotificationFeed();

        // Add some notifications (simulating user actions)
        feed.addNotification(new LikeNotification("user123"));
        feed.addNotification(new CommentNotification("user456"));
        feed.addNotification(new FollowNotification("user789"));
        feed.addNotification(new LikeNotification("userABC"));
        feed.addNotification(new CommentNotification("userXYZ"));

        // Display notifications
        feed.displayNotifications();

        // Show unread count
        System.out.println("\nUnread notifications: " + feed.getUnreadCount());
    }
}
