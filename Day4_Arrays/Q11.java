package Day4_Arrays;
import java.util.Scanner;
public class Q11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of persons: ");
        int number = sc.nextInt();
        double[][] personData = new double[number][3]; // [height, weight, BMI]
        String[] weightStatus = new String[number];
        for (int i = 0; i < number; i++) {
            double height, weight;
            while (true) {
                System.out.print("Enter height (in meters) for person " + (i + 1) + ": ");
                height = sc.nextDouble();
                System.out.print("Enter weight (in kg) for person " + (i + 1) + ": ");
                weight = sc.nextDouble();
                if (height > 0 && weight > 0) break;
                else System.out.println("Invalid input. Please enter positive values.");
            }
            double bmi = weight / (height * height);
            personData[i][0] = height;
            personData[i][1] = weight;
            personData[i][2] = bmi;

            // Determine weight status
            if (bmi < 18.5) weightStatus[i] = "Underweight";
            else if (bmi < 24.9) weightStatus[i] = "Normal weight";
            else if (bmi < 29.9) weightStatus[i] = "Overweight";
            else weightStatus[i] = "Obese";
        }

        System.out.println("\n--- BMI Report ---");
        for (int i = 0; i < number; i++) {
            System.out.printf("Person %d: Height = %.2f m, Weight = %.2f kg, BMI = %.2f, Status = %s\n",
                    (i + 1), personData[i][0], personData[i][1], personData[i][2], weightStatus[i]);
        }
    }
}
