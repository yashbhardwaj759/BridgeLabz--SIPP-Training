package Day5_JavaStrings;
import java.util.Scanner;
class Q13 {
    public static String getComputerChoice() {
        int r = (int)(Math.random() * 3);
        return (r == 0 ? "rock" : r == 1 ? "paper" : "scissors");
    }
    public static String getWinner(String user, String comp) {
        if (user.equals(comp)) return "Draw";
        if ((user.equals("rock") && comp.equals("scissors")) ||
            (user.equals("paper") && comp.equals("rock")) ||
            (user.equals("scissors") && comp.equals("paper")))
            return "User";
        return "Computer";
    }
    public static void displayStats(int games, int userWins, int compWins) {
        System.out.println("Games: " + games);
        System.out.println("User Wins: " + userWins);
        System.out.println("Computer Wins: " + compWins);
        System.out.println("User Win %: " + (userWins * 100 / games));
        System.out.println("Computer Win %: " + (compWins * 100 / games));
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int games = sc.nextInt();
        int userWins = 0, compWins = 0;
        for (int i = 0; i < games; i++) {
            System.out.print("Enter rock/paper/scissors: ");
            String user = sc.next();
            String comp = getComputerChoice();
            String winner = getWinner(user, comp);
            if (winner.equals("User")) userWins++;
            else if (winner.equals("Computer")) compWins++;
            System.out.println("Computer chose: " + comp + ", Winner: " + winner);
        }
        displayStats(games, userWins, compWins);
    }
}