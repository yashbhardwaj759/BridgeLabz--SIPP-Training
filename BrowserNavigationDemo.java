import java.util.Stack;

// BrowserTab represents an individual tab with content
class BrowserTab {
    private final String url;
    private final String title;

    public BrowserTab(String url, String title) {
        this.url = url;
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return title + " (" + url + ")";
    }
}

// NavigationManager interface defines the contract
interface NavigationManager {
    void openTab(BrowserTab tab);

    BrowserTab goBack();

    BrowserTab goForward();

    BrowserTab getCurrentTab();

    boolean hasBackHistory();

    boolean hasForwardHistory();
}

// Base implementation for desktop browsers
class DesktopNavigationManager implements NavigationManager {
    private final Stack<BrowserTab> backStack = new Stack<>();
    private final Stack<BrowserTab> forwardStack = new Stack<>();
    private BrowserTab currentTab;

    @Override
    public void openTab(BrowserTab tab) {
        if (currentTab != null) {
            backStack.push(currentTab);
        }
        currentTab = tab;
        forwardStack.clear(); // Navigation reset when opening new tab
        System.out.println("Desktop: Opened tab - " + tab);
    }

    @Override
    public BrowserTab goBack() {
        if (!hasBackHistory()) {
            throw new IllegalStateException("No back history available");
        }
        forwardStack.push(currentTab);
        currentTab = backStack.pop();
        System.out.println("Desktop: Navigated back to - " + currentTab);
        return currentTab;
    }

    @Override
    public BrowserTab goForward() {
        if (!hasForwardHistory()) {
            throw new IllegalStateException("No forward history available");
        }
        backStack.push(currentTab);
        currentTab = forwardStack.pop();
        System.out.println("Desktop: Navigated forward to - " + currentTab);
        return currentTab;
    }

    @Override
    public BrowserTab getCurrentTab() {
        return currentTab;
    }

    @Override
    public boolean hasBackHistory() {
        return !backStack.isEmpty();
    }

    @Override
    public boolean hasForwardHistory() {
        return !forwardStack.isEmpty();
    }
}

// Mobile implementation with different behavior
class MobileNavigationManager implements NavigationManager {
    private final Stack<BrowserTab> backStack = new Stack<>();
    private final Stack<BrowserTab> forwardStack = new Stack<>();
    private BrowserTab currentTab;

    @Override
    public void openTab(BrowserTab tab) {
        if (currentTab != null) {
            backStack.push(currentTab);
        }
        currentTab = tab;
        // Mobile browsers typically have a smaller forward stack capacity
        if (forwardStack.size() > 3) {
            forwardStack.remove(0); // Remove oldest entry
        }
        System.out.println("Mobile: Opened tab - " + tab);
    }

    @Override
    public BrowserTab goBack() {
        if (!hasBackHistory()) {
            throw new IllegalStateException("No back history available");
        }
        forwardStack.push(currentTab);
        currentTab = backStack.pop();
        System.out.println("Mobile: Swiped back to - " + currentTab);
        return currentTab;
    }

    @Override
    public BrowserTab goForward() {
        if (!hasForwardHistory()) {
            throw new IllegalStateException("No forward history available");
        }
        backStack.push(currentTab);
        currentTab = forwardStack.pop();
        System.out.println("Mobile: Swiped forward to - " + currentTab);
        return currentTab;
    }

    @Override
    public BrowserTab getCurrentTab() {
        return currentTab;
    }

    @Override
    public boolean hasBackHistory() {
        return !backStack.isEmpty();
    }

    @Override
    public boolean hasForwardHistory() {
        return !forwardStack.isEmpty();
    }
}

// Demo usage
public class BrowserNavigationDemo {
    public static void main(String[] args) {
        System.out.println("=== Desktop Browser Navigation ===");
        NavigationManager desktopNav = new DesktopNavigationManager();
        demoNavigation(desktopNav);

        System.out.println("\n=== Mobile Browser Navigation ===");
        NavigationManager mobileNav = new MobileNavigationManager();
        demoNavigation(mobileNav);
    }

    private static void demoNavigation(NavigationManager manager) {
        BrowserTab tab1 = new BrowserTab("https://www.google.com", "Google");
        BrowserTab tab2 = new BrowserTab("https://www.github.com", "GitHub");
        BrowserTab tab3 = new BrowserTab("https://www.stackoverflow.com", "Stack Overflow");

        manager.openTab(tab1);
        manager.openTab(tab2);
        manager.openTab(tab3);

        // Navigate back twice
        manager.goBack();
        manager.goBack();

        // Navigate forward once
        manager.goForward();

        try {
            manager.goForward(); // Should throw exception
        } catch (IllegalStateException e) {
            System.out.println("Expected error: " + e.getMessage());
        }
    }
}
