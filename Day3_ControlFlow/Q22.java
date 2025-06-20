import java.util.Scanner;
public class Q22{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter age of Amar: ");
        int ageAmar = sc.nextInt();
        System.out.print("Enter height of Amar (in cm): ");
        int heightAmar = sc.nextInt();
        System.out.print("Enter age of Akbar: ");
        int ageAkbar = sc.nextInt();
        System.out.print("Enter height of Akbar (in cm): ");
        int heightAkbar = sc.nextInt();
        System.out.print("Enter age of Anthony: ");
        int ageAnthony = sc.nextInt();
        System.out.print("Enter height of Anthony (in cm): ");
        int heightAnthony = sc.nextInt();
        String youngest = "Amar";
        int minAge = ageAmar;
        if (ageAkbar < minAge) {
            youngest = "Akbar";
            minAge = ageAkbar;
        }
        if (ageAnthony < minAge) {
            youngest = "Anthony";
        }
        String tallest = "Amar";
        int maxHeight = heightAmar;
        if (heightAkbar > maxHeight) {
            tallest = "Akbar";
            maxHeight = heightAkbar;
        }
        if (heightAnthony > maxHeight) {
            tallest = "Anthony";
        }
        System.out.println("Youngest friend is: " + youngest);
        System.out.println("Tallest friend is: " + tallest);
    }
}
