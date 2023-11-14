
import java.util.Scanner;
import java.util.Random;

public class NumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        int rangeStart = 1;
        int rangeEnd = 100;
        int maxAttempts = 10;
        int score = 0;
        
        System.out.println("Welcome to the Number Game!");
        System.out.println("You have " + maxAttempts + " attempts to guess the number between " + rangeStart + " and " + rangeEnd + ".");
        
        boolean playAgain = true;
        while (playAgain) {
            int secretNumber = random.nextInt(rangeEnd - rangeStart + 1) + rangeStart;
            int attempts = 0;
            
            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int guess = scanner.nextInt();
                attempts++;
                
                if (guess < secretNumber) {
                    System.out.println("Too low! Try again.");
                } else if (guess > secretNumber) {
                    System.out.println("Too high! Try again.");
                } else {
                    System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
                    score++;
                    break;
                }
            }
            
            if (attempts == maxAttempts) {
                System.out.println("Sorry, you ran out of attempts. The number was " + secretNumber + ".");
            }
            
            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainInput = scanner.next();
            playAgain = playAgainInput.equalsIgnoreCase("yes");
        }
        
        System.out.println("Your final score is: " + score);
        
        scanner.close();
    }
}