package hexlet.code;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        String username;
        boolean isRunning = true;
        while (isRunning) {
            switch (chooseMenuOption()) {
                case 1:
                    Cli.greeting();
                    isRunning = false;
                    break;
                case 2:
                    username = Cli.greeting();
                    startEvenGame(username);
                    isRunning = false;
                    break;
                case 0:
                    isRunning = false;
                    break;
                default:
                    System.out.println("Wrong menu option!");
                    break;
            }
        }
    }

    public static int chooseMenuOption() {
        System.out.print("Please enter the game number and press Enter.\n"
                + "1 - Greet\n"
                + "2 - Even\n"
                + "0 - Exit\n"
                + "Your choice: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    private static void startEvenGame(String username) {
        final int levelsToBeatTheGame = 3;
        final int lastLevel = 0;
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");
        boolean isCorrect = true;
        int level = levelsToBeatTheGame;
        while (isCorrect) {
            --level;
            isCorrect = oneRoundEvenGame(level);
            if (level == lastLevel && isCorrect) {
                System.out.println("Congratulations " + username + "!");
                break;
            }
        }

    }

    private static boolean oneRoundEvenGame(int level) {
        int number = (int) (Math.random() * 100);
        System.out.println("Question: " + number);
        Scanner scanner = new Scanner(System.in);
        System.out.print("Your answer: ");
        String answer = scanner.nextLine();
        String correctAnswer = (number % 2 == 0) ? "yes" : "no";
        if (answer.equals(correctAnswer)) {
            if (level != 1) {
                System.out.println("Correct!");
            }
            return true;
        } else {
            System.out.println("'" + answer + "'  is wrong answer ;(. Correct answer was " + correctAnswer);
            return false;
        }
    }
}
