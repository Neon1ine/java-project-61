package hexlet.code;

import hexlet.code.games.Even;
import hexlet.code.games.Calc;
import hexlet.code.games.GCD;
import hexlet.code.games.Progression;
import hexlet.code.games.Prime;

import java.util.Scanner;

public class Engine {
    private static final int LEVELS_TO_BEAT_THE_GAME = 3;
    private static final int RANDOM_GENERATOR_RANGE = 100;

    public static int generateRandomNumberInRange(int first, int last) {
        return (int) (first + Math.random() * last);
    }

    public static int generateRandomNumber() {
        return (int) (Math.random() * RANDOM_GENERATOR_RANGE);
    }

    public static void startGame(int gameId) {
        boolean isCorrect;
        for (int level = 1; level <= LEVELS_TO_BEAT_THE_GAME; level++) {
            isCorrect = oneRoundOfGame(gameId, level);
            if (!isCorrect) {
                endOfAGame(false);
                break;
            }
            if (level == LEVELS_TO_BEAT_THE_GAME) {
                endOfAGame(true);
                break;
            }
        }
    }

    private static void endOfAGame(boolean isWin) {
        StringBuilder output = new StringBuilder();
        if (isWin) {
            output.append("Congratulations, ");
        } else {
            output.append("Let's try again, ");
        }
        output.append(Cli.getUsername()).append("!");
        System.out.println(output);
    }

    private static boolean oneRoundOfGame(int gameId, int level) {
        String question = createQuestion(gameId);
        String userAnswer = askUserForAnswer(question);
        String correctAnswer = defineCorrectAnswer(gameId);
        if (userAnswer.equals(correctAnswer)) {
            if (level < LEVELS_TO_BEAT_THE_GAME) {
                System.out.println("Correct!");
            }
            return true;
        } else {
            StringBuilder output = new StringBuilder();
            output.append("'").append(userAnswer)
                    .append("'  is wrong answer ;(. Correct answer was '")
                    .append(correctAnswer).append("'");
            System.out.println(output);
            return false;
        }
    }

    private static String createQuestion(int gameId) {
        switch (gameId) {
            case Menu.SECOND_OPTION:
                return Even.generateRandomNumberAsQuestion();
            case Menu.THIRD_OPTION:
                return Calc.generateRandomOperation();
            case Menu.FOURTH_OPTION:
                return GCD.generate2Numbers();
            case Menu.FIFTH_OPTION:
                return Progression.generateProgression();
            case Menu.SIXTH_OPTION:
                return Prime.generateRandomNumberAsQuestion();
            default:
                System.out.println("Error in defineQuestion: wrong gameId - " + gameId);
                return null;

        }
    }

    private static String askUserForAnswer(String question) {
        System.out.println("Question: " + question);
        Scanner scanner = new Scanner(System.in);
        System.out.print("Your answer: ");
        return scanner.nextLine();
    }

    private static String defineCorrectAnswer(int gameId) {
        switch (gameId) {
            case Menu.SECOND_OPTION:
                return Even.isEven();
            case Menu.THIRD_OPTION:
                return Calc.getAnswer();
            case Menu.FOURTH_OPTION:
                return GCD.findGCD();
            case Menu.FIFTH_OPTION:
                return Progression.getMissingNumber();
            case Menu.SIXTH_OPTION:
                return Prime.isPrime();
            default:
                System.out.println("Error in defineCorrectAnswer: wrong gameId - " + gameId);
                return null;
        }
    }

}
