import java.util.Random;
import java.util.Scanner;

public class DiceGame {

    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);
        Random rnd = new Random();

        String playAgain;

        do {

            int die1 = rnd.nextInt(6) + 1;
            int die2 = rnd.nextInt(6) + 1;
            int sum = die1 + die2;

            System.out.println("\nFirst Roll");
            System.out.println("Die 1: " + die1);
            System.out.println("Die 2: " + die2);
            System.out.println("Sum: " + sum);

            // Craps (2, 3, or 12)
            if (sum == 2 || sum == 3 || sum == 12) {
                System.out.println("Craps! You lose.");
            }

            // Natural (Sum of 7 or 11)
            else if (sum == 7 || sum == 11) {
                System.out.println("Natural! You win.");
            }

            // Point is established
            else {

                int point = sum;

                System.out.println("Point is " + point);

                boolean gameOver = false;

                while (!gameOver) {

                    die1 = rnd.nextInt(6) + 1;
                    die2 = rnd.nextInt(6) + 1;
                    sum = die1 + die2;

                    System.out.println("\nRolling again...");
                    System.out.println("Die 1: " + die1);
                    System.out.println("Die 2: " + die2);
                    System.out.println("Sum: " + sum);

                    if (sum == point) {
                        System.out.println("Made point and won!");
                        gameOver = true;
                    }
                    else if (sum == 7) {
                        System.out.println("Got a seven and lost.");
                        gameOver = true;
                    }
                    else {
                        System.out.println("Trying for point...");
                    }
                }
            }

            // Bulletproof input
            do {
                System.out.print("\nPlay again? (Y/N): ");
                playAgain = keyboard.nextLine().trim().toUpperCase();

                if (!playAgain.equals("Y") && !playAgain.equals("N")) {
                    System.out.println("Invalid input. Enter Y or N.");
                }

            } while (!playAgain.equals("Y") && !playAgain.equals("N"));

        } while (playAgain.equals("Y"));

        System.out.println("Thanks for playing!");

        keyboard.close();
    }
}