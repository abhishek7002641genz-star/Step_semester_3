import java.util.Scanner;

public class RockPaperScissors {

    static String playRound(String playerMove, String computerMove) {

        if (playerMove.equals(computerMove))
            return "Draw";

        if ((playerMove.equals("Rock") && computerMove.equals("Scissors")) ||
            (playerMove.equals("Paper") && computerMove.equals("Rock")) ||
            (playerMove.equals("Scissors") && computerMove.equals("Paper")))
            return "Player Wins";

        return "Computer Wins";
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] moves = {"Rock", "Paper", "Scissors"};
        String[] playerMoves = new String[5];
        String[] computerMoves = new String[5];
        String[] results = new String[5];

        int wins = 0;
        int losses = 0;
        int draws = 0;

        try {
            for (int i = 0; i < 5; i++) {

                System.out.print("Enter Rock, Paper or Scissors: ");
                String playerMove = scanner.nextLine().trim();

                if (!playerMove.equalsIgnoreCase("Rock") &&
                    !playerMove.equalsIgnoreCase("Paper") &&
                    !playerMove.equalsIgnoreCase("Scissors")) {

                    System.out.println("Invalid move. Try again.");
                    i--;
                    continue;
                }

                playerMove = playerMove.substring(0, 1).toUpperCase()
                           + playerMove.substring(1).toLowerCase();

                int randomIndex = (int)(Math.random() * 3);
                String computerMove = moves[randomIndex];

                String result = playRound(playerMove, computerMove);

                playerMoves[i] = playerMove;
                computerMoves[i] = computerMove;
                results[i] = result;

                if (result.equals("Player Wins"))
                    wins++;
                else if (result.equals("Computer Wins"))
                    losses++;
                else
                    draws++;
            }

            System.out.println("\nRound\tPlayer\t\tComputer\tResult");

            for (int i = 0; i < 5; i++) {
                System.out.println((i + 1) + "\t" + playerMoves[i] +
                        "\t\t" + computerMoves[i] + "\t\t" + results[i]);
            }

            double winPercentage = (wins / 5.0) * 100;

            System.out.println("\nWins: " + wins);
            System.out.println("Losses: " + losses);
            System.out.println("Draws: " + draws);
            System.out.println("Win Percentage: " + winPercentage + "%");

        } catch (Exception exception) {
            System.out.println("An error occurred: " + exception.getMessage());
        }

        scanner.close();
    }
}
