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
                    System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");
                    startGame(2 ,username);
                    isRunning = false;
                    break;
                case 3:
                    username = Cli.greeting();
                    System.out.println("What is the result of the expression?");
                    startGame(3, username);
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
                + "3 - Calc\n"
                + "0 - Exit\n"
                + "Your choice: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    private final static int LEVELS_TO_BEAT_THE_GAME = 3;
    private static final int RANDOM_GENERATOR_RANGE = 100;

    private static void startGame(int gameId, String username) {
        boolean isCorrect = true;
        int level = LEVELS_TO_BEAT_THE_GAME;
        while (isCorrect) {
            --level;
            isCorrect = oneRoundOfGame(gameId, level);
            if (level == 0 && isCorrect) {
                //todo stringBuilder
                System.out.println("Congratulations " + username + "!");
                break;
            }
        }

    }

    private static boolean oneRoundOfGame(int gameId, int level) {
        String question = defineQuestion(gameId);
        String userAnswer = askUserForAnswer(question);
        String correctAnswer = defineCorrectAnswer(gameId, question);
        if (userAnswer.equals(correctAnswer)) {
            if (level != 1) {
                System.out.println("Correct!");
            }
            return true;
        } else {
            //todo stringBuilder
            System.out.println("'" + userAnswer + "'  is wrong answer ;(. Correct answer was '" + correctAnswer +"'");
            return false;
        }
    }

    private static String defineQuestion(int gameId) {
        switch (gameId) {
            case 2:
                return generateRandomNumber();
            case 3:
                return generateRandomNumber() + " + " + generateRandomNumber();
            default:
                System.out.println("Error in defineQuestion: wrong gameId - " + gameId);
                return null;

        }
    }

    private static String generateRandomNumber() {
        return String.valueOf((int) (Math.random() * RANDOM_GENERATOR_RANGE));
    }

    private static String askUserForAnswer(String question) {
        System.out.println("Question: " + question);
        Scanner scanner = new Scanner(System.in);
        System.out.print("Your answer: ");
        return scanner.nextLine();
    }

    private static String defineCorrectAnswer(int gameId, String question) {
        switch (gameId) {
            case 2:
                return (Integer.parseInt(question) % 2 == 0) ? "yes" : "no";
            case 3:
                //todo разбить вопрос на 2 числа и знак
                return null;
            default:
                System.out.println("Error in defineCorrectAnswer: wrong gameId - " + gameId);
                return null;
        }

    }


}
