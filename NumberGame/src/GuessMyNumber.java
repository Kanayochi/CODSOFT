import java.util.Scanner;
import java.util.Random;
// hi this is number guess task, i used cmd for the interface and a while loop for rounds.
public class GuessMyNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int totalAttempts = 0;
        int totalRounds = 0;

        boolean playAgain = true;

        while (playAgain) {
            int CorrectNumber = random.nextInt(100) + 1;
            int attempts = 0;
            int rounds = 1;

            System.out.println("\nRound " + rounds);

            while (true) {
                System.out.print("Enter your guess (1-100): ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == CorrectNumber) {
                    System.out.println("Boom! You guessed the number " + CorrectNumber + " in " + attempts + " attempts.");
                    totalAttempts += attempts;
                    totalRounds++;
                    break;
                } else if (userGuess < CorrectNumber) {
                    System.out.println("Doom! Too low. Try again a little more.");
                } else {
                    System.out.println("Doom! Too high. Try again, you got this.");
                }

                if (attempts == 7) {
                    System.out.println("Sorry mate, you've reached the maximum number of attempts. The correct number was: " + CorrectNumber);
                    break;
                }
            }

            System.out.print("Do you want to try play again? (yes/no): ");
            String playAgainInput = scanner.next().toLowerCase();
            playAgain = playAgainInput.equals("yes");

            rounds++;

            totalRounds = rounds;
        }

        System.out.println("Game Over. Your total score is based on attempts: " + totalAttempts + " in " + totalRounds + " rounds.");
        scanner.close();
    }
}
