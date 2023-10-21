package hexlet.code;

import hexlet.code.games.Even;
import hexlet.code.games.Calc;
import hexlet.code.games.GCD;

import java.util.Scanner;

public class Engine {
    private static final int LEVELS_TO_BEAT_THE_GAME = 3;
    private static final int RANDOM_GENERATOR_RANGE = 100;

    public static void startGame(int gameId, String username) {
        boolean isCorrect;
        for (int level = 1; level <= LEVELS_TO_BEAT_THE_GAME; level++) {
            isCorrect = oneRoundOfGame(gameId, level);
            if (!isCorrect) {
                endgame(username, false);
                break;
            }
            if (level == LEVELS_TO_BEAT_THE_GAME) {
                endgame(username, true);
                break;
            }
        }
    }

    private static void endgame(String username, boolean isWin) {
        StringBuffer output = new StringBuffer();
        if (isWin) {
            output.append("Congratulations ");
        } else {
            output.append("Let's try again, ");
        }
        output.append(username).append("!");
        System.out.println(output);
    }

    private static boolean oneRoundOfGame(int gameId, int level) {
        String question = createQuestion(gameId);
        String userAnswer = askUserForAnswer(question);
        String correctAnswer = defineCorrectAnswer(gameId, question);
        if (userAnswer.equals(correctAnswer)) {
            if (level < LEVELS_TO_BEAT_THE_GAME) {
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

    private static String createQuestion(int gameId) {
        switch (gameId) {
            case 2:
                return generateRandomNumber();
            case 3:
                return Calc.generateRandomOperation();
            case 4:
                return generateRandomNumber() + " " + generateRandomNumber();
            default:
                System.out.println("Error in defineQuestion: wrong gameId - " + gameId);
                return null;

        }
    }

    public static String generateRandomNumber() {
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
                return Even.findIsEven(question);
            case 3:
                return Calc.findOperandsAndSign(question);
            case 4:
                return GCD.findGCD(question);
            default:
                System.out.println("Error in defineCorrectAnswer: wrong gameId - " + gameId);
                return null;
        }
    }

    public static int findOperand(String question, boolean isFirst) {
        int a = 0;
        int b = 0;

        for (int i = 0; i < question.length(); i++) {
            char ch = question.charAt(i);
            if (Character.isDigit(ch)) {
                if (i < 2) {
                    a = a * 10 + Character.getNumericValue(ch);
                } else {
                    b = b * 10 + Character.getNumericValue(ch);
                }
            }
        }

        return isFirst ? a : b;
    }
}
