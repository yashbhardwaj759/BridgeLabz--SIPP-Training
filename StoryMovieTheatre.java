import java.util.ArrayList;
import java.util.Scanner;

public class StoryMovieTheatre {
    public static void main(String[] args) {
        ArrayList<String> showNames = new ArrayList<>();
        ArrayList<String> showTimes = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        String choice;

        do {
            System.out.print("Enter show name: ");
            String name = scanner.nextLine();

            System.out.print("Enter show time (HH:MM): ");
            String time = scanner.nextLine();

            // Add to end of list
            showNames.add(name);
            showTimes.add(time);

            // Insertion sort step for new entry
            int i = showTimes.size() - 1;
            while (i > 0 && toMinutes(showTimes.get(i)) < toMinutes(showTimes.get(i - 1))) {
                // Swap times
                String tempTime = showTimes.get(i);
                showTimes.set(i, showTimes.get(i - 1));
                showTimes.set(i - 1, tempTime);

                // Swap names to match
                String tempName = showNames.get(i);
                showNames.set(i, showNames.get(i - 1));
                showNames.set(i - 1, tempName);

                i--;
            }

            System.out.print("Add another show? (yes/no): ");
            choice = scanner.nextLine();

        } while (choice.equalsIgnoreCase("yes"));

        // Display shows
        System.out.println("\nUpcoming Shows:");
        for (int i = 0; i < showNames.size(); i++) {
            System.out.println(showTimes.get(i) + " - " + showNames.get(i));
        }

        scanner.close();
    }

    // Helper to convert HH:MM to minutes
    public static int toMinutes(String time) {
        String[] parts = time.split(":");
        return Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]);
    }
}