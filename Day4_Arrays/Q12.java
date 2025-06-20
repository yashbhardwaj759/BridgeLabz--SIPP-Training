package Day4_Arrays;
import java.util.Scanner;
public class Q12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        int[][] marks = new int[n][3]; // physics, chemistry, maths
        double[] percentages = new double[n];
        char[] grades = new char[n];

        for (int i = 0; i < n; ) {
            System.out.println("Enter marks for Student " + (i + 1) + ":");

            System.out.print("Physics: ");
            int phy = sc.nextInt();
            System.out.print("Chemistry: ");
            int chem = sc.nextInt();
            System.out.print("Maths: ");
            int math = sc.nextInt();

            if (phy < 0 || chem < 0 || math < 0) {
                System.out.println("Marks cannot be negative. Try again.");
                continue;
            }

            marks[i][0] = phy;
            marks[i][1] = chem;
            marks[i][2] = math;

            double percent = (phy + chem + math) / 3.0;
            percentages[i] = percent;

            if (percent >= 90) grades[i] = 'A';
            else if (percent >= 80) grades[i] = 'B';
            else if (percent >= 70) grades[i] = 'C';
            else if (percent >= 60) grades[i] = 'D';
            else grades[i] = 'F';

            i++;
        }

        System.out.println("\n--- Student Report ---");
        for (int i = 0; i < n; i++) {
            System.out.printf("Student %d: Physics = %d, Chemistry = %d, Maths = %d, Percentage = %.2f%%, Grade = %c\n",
                    (i + 1), marks[i][0], marks[i][1], marks[i][2], percentages[i], grades[i]);
        }

        sc.close();
    }
}
