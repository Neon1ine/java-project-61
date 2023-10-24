package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Menu;

public class Even {
    private static int number;
    private static final String invite = "Answer 'yes' if the number is even, otherwise answer 'no'.";

    public static void start() {
        Engine.startGame(Menu.SECOND_OPTION);
    }

    public static String isEven() {
        return (number % 2 == 0) ? "yes" : "no";
    }

    public static String generateRandomNumberAsQuestion() {
        number = Engine.generateRandomNumber();
        return String.valueOf(number);
    }

    public static String getInvite() {
        return invite;
    }
}
