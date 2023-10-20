package hexlet.code;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        drawMenu();
    }

    private static void drawMenu() {
        String username = "";
        int userChoice = chooseMenuOption();
        switch (userChoice) {
            case 1:
                Cli.greeting();
                break;
            case 2, 3:
                username = Cli.greeting();
                if (userChoice == 2) {
                    System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");
                } else {
                    System.out.println("What is the result of the expression?");
                }
                break;
            case 0:
                break;
            default:
                System.out.println("Wrong menu option!");
                drawMenu();
                break;
        }

        startGame(userChoice, username);
    }

    public static int chooseMenuOption() {
        System.out.print("""
                Please enter the game number and press Enter.
                1 - Greet
                2 - Even
                3 - Calc
                0 - Exit
                Your choice:\s""");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    private static final int LEVELS_TO_BEAT_THE_GAME = 3;
    private static final int RANDOM_GENERATOR_RANGE = 100;

    private static void startGame(int gameId, String username) {
        boolean isCorrect = true;
        int level = LEVELS_TO_BEAT_THE_GAME;
        while (isCorrect) {
            --level;
            isCorrect = oneRoundOfGame(gameId, level);
            StringBuffer output = new StringBuffer();
            if (level == 0 && isCorrect) {
                output.append("Congratulations ").append(username).append("!");
                System.out.println(output);
                break;
            } else if (!isCorrect) {
                output.append("Let's try again, ").append(username).append("!");
                System.out.println(output);
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
            StringBuffer output = new StringBuffer();
            output.append("'").append(userAnswer).append("'  is wrong answer ;(. Correct answer was '")
                    .append(correctAnswer).append("'");
            System.out.println(output);
            return false;
        }
    }

    private static String defineQuestion(int gameId) {
        switch (gameId) {
            case 2:
                return generateRandomNumber();
            case 3:
                return generateRandomNumber() + generateRandomOperation() + generateRandomNumber();
            default:
                System.out.println("Error in defineQuestion: wrong gameId - " + gameId);
                return null;

        }
    }

    private static String generateRandomNumber() {
        return String.valueOf((int) (Math.random() * RANDOM_GENERATOR_RANGE));
    }

    private static String generateRandomOperation() {
        int operationIndex = (int) (Math.random() * 3);
        StringBuffer output = new StringBuffer();
        output.append(" ");
        switch (operationIndex) {
            case 0:
                output.append("*");
                break;
            case 1:
                output.append("+");
                break;
            case 2:
                output.append("-");
                break;
            default:
                System.out.println("Error in generateRandomOperation: "
                        + "wrong generateRandomOperation - " + operationIndex);
                break;
        }
        output.append(" ");
        return String.valueOf(output);
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
                return String.valueOf(calculateAnswer(question));
            default:
                System.out.println("Error in defineCorrectAnswer: wrong gameId - " + gameId);
                return null;
        }
    }

    private static int calculateAnswer(String question) {
        int first = 0;
        int second = 0;
        char sign = 0;
        for (int i = 0; i < question.length(); i++) {
            char ch = question.charAt(i);
            if (ch < 58 && ch > 47 && i < 2) {
                first = first * 10 + ch - 48;
            } else if (ch == 42 || ch == 43 || ch == 45) {
                sign = ch;
            } else if (ch < 58 && ch > 47 && i > 3) {
                second = second * 10 + ch - 48;
            }
        }

        switch ((int) sign) {
            case 42:
                return first * second;
            case 43:
                return first + second;
            case 45:
                return first - second;
            default:
                System.out.println("Error in calculateAnswer: wrong operation - " + (int) sign);
                return 0;
        }
    }
}
