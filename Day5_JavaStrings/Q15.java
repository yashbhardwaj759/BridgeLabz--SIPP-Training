package Day5_JavaStrings;
import java.util.Scanner;
class Q15 {
    public static int[][] generateScores(int n) {
        int[][] scores = new int[n][3];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < 3; j++)
                scores[i][j] = 40 + (int)(Math.random() * 60);
        return scores;
    }
    public static double[][] calculateStats(int[][] scores) {
        double[][] result = new double[scores.length][3];
        for (int i = 0; i < scores.length; i++) {
            int total = scores[i][0] + scores[i][1] + scores[i][2];
            double avg = total / 3.0;
            double perc = (total / 300.0) * 100;
            result[i][0] = total;
            result[i][1] = Math.round(avg * 100) / 100.0;
            result[i][2] = Math.round(perc * 100) / 100.0;
        }
        return result;
    }
    public static String[] calculateGrades(double[][] stats) {
        String[] grades = new String[stats.length];
        for (int i = 0; i < stats.length; i++) {
            double p = stats[i][2];
            if (p >= 90) grades[i] = "A+";
            else if (p >= 80) grades[i] = "A";
            else if (p >= 70) grades[i] = "B+";
            else if (p >= 60) grades[i] = "B";
            else if (p >= 50) grades[i] = "C";
            else grades[i] = "F";
        }
        return grades;
    }
    public static void main(String[] args) {
        int[][] scores = generateScores(5);
        double[][] stats = calculateStats(scores);
        String[] grades = calculateGrades(stats);
        for (int i = 0; i < scores.length; i++) {
            System.out.println("Physics: " + scores[i][0] + ", Chemistry: " + scores[i][1] + ", Math: " + scores[i][2] + ", Total: " + (int)stats[i][0] + ", %: " + stats[i][2] + ", Grade: " + grades[i]);
        }
    }
}
