package hexlet.code;

import java.util.Scanner;
import hexlet.code.games.Game;

public class Engine {
    private static final int LEVELS_TO_BEAT_THE_GAME = 3;
    private static final int RANDOM_GENERATOR_RANGE = 100;

    public static int generateRandomNumberInRange(int first, int last) {
        return (int) (first + Math.random() * last);
    }

    public static int generateRandomNumber() {
        return (int) (Math.random() * RANDOM_GENERATOR_RANGE);
    }

    public static void startGame(Game game) {
        String username = Cli.greeting();
        System.out.println(game.getInvite());
        for (int level = 1; level <= LEVELS_TO_BEAT_THE_GAME; level++) {
            String question = game.createQuestion();
            System.out.println("Question: " + question);
            Scanner scanner = new Scanner(System.in);
            System.out.print("Your answer: ");
            String userAnswer = scanner.nextLine();
            String correctAnswer = game.defineCorrectAnswer();
            StringBuilder output = new StringBuilder();
            if (userAnswer.equals(correctAnswer)) {
                //if it's not the last level
                if (level != LEVELS_TO_BEAT_THE_GAME) {
                    output.append("Correct!");
                } else {
                    output.append("Congratulations, ").append(username).append("!");
                }
            } else {
                output.append("'").append(userAnswer)
                        .append("' is wrong answer ;(. Correct answer was '")
                        .append(correctAnswer).append("'").append("\nLet's try again, ")
                        .append(username).append("!");
                System.out.println(output);
                break;
            }
            System.out.println(output);
        }
    }

}
