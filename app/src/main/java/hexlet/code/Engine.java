package hexlet.code;

import java.util.Scanner;
import hexlet.code.games.Game;

public class Engine {
    private static final int LEVELS_TO_BEAT_THE_GAME = 3;

    public static void startGame(Game game) {
        String username = Cli.greeting();
        System.out.println(game.getRules());
        for (int level = 1; level <= LEVELS_TO_BEAT_THE_GAME; level++) {
            String[] gameData = game.getData();
            System.out.println("Question: " + gameData[0]);
            Scanner scanner = new Scanner(System.in);
            System.out.print("Your answer: ");
            String userAnswer = scanner.nextLine();
            StringBuilder output = new StringBuilder();
            if (userAnswer.equals(gameData[1])) {
                //if it's not the last level
                if (level != LEVELS_TO_BEAT_THE_GAME) {
                    output.append("Correct!");
                } else {
                    output.append("Congratulations, ").append(username).append("!");
                }
            } else {
                output.append("'").append(userAnswer)
                        .append("'  is wrong answer ;(. Correct answer was '")
                        .append(gameData[1]).append("'").append("\nLet's try again, ")
                        .append(username).append("!");
                System.out.println(output);
                break;
            }
            System.out.println(output);
        }
    }

}
