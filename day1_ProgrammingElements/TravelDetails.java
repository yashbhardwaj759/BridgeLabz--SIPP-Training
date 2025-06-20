import java.util.Scanner;

public class TravelDetails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        System.out.print("Enter from city: ");
        String fromCity = scanner.nextLine();
        System.out.print("Enter via city: ");
        String viaCity = scanner.nextLine();
        System.out.print("Enter to city: ");
        String toCity = scanner.nextLine();
        System.out.print("Enter distance from fromCity to viaCity (in miles): ");
        double fromToVia = scanner.nextDouble();
        System.out.print("Enter distance from viaCity to toCity (in miles): ");
        double viaToFinalCity = scanner.nextDouble();
        System.out.print("Enter time from fromCity to viaCity (in hours): ");
        double timeFromToVia = scanner.nextDouble();
        System.out.print("Enter time from viaCity to toCity (in hours): ");
        double timeViaToFinalCity = scanner.nextDouble();
        double totalDistance = fromToVia + viaToFinalCity;
        double totalTime = timeFromToVia + timeViaToFinalCity;
        System.out.printf("%s is travelling from %s to %s via %s. Total distance is %.2f miles and total time is %.2f hours.\n", name, fromCity, toCity, viaCity, totalDistance, totalTime);
        scanner.close();
    }
} 