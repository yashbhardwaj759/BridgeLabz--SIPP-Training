// Question 19
import java.util.Scanner;
public class Q19 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String name = sc.next();
        String fromCity = sc.next();
        String viaCity = sc.next();
        String toCity = sc.next();
        double fromToVia = sc.nextDouble();
        double viaToFinal = sc.nextDouble();
        double timeFromToVia = sc.nextDouble();
        double timeViaToFinal = sc.nextDouble();
        double totalDistance = fromToVia + viaToFinal;
        double totalTime = timeFromToVia + timeViaToFinal;
        System.out.println("The Total Distance travelled by " + name + " from " + fromCity + " to " + toCity + " via " + viaCity + " is " + totalDistance + " km and the Total Time taken is " + totalTime + " minutes");
    }
}
