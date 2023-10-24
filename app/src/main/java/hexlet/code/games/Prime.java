package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Menu;

public class Prime {
    private static int number;
    private static final int PRIME_NUMBER_RANGE = 20;
    private static final String invite = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    public static void start() {
        Engine.startGame(Menu.SIXTH_OPTION);
    }

    public static String generateRandomNumberAsQuestion() {
        number = Engine.generateRandomNumberInRange(1, PRIME_NUMBER_RANGE);
        return String.valueOf(number);
    }

    public static String isPrime() {
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return "no";
            }
        }
        return "yes";
    }

    public static String getInvite() {
        return invite;
    }
}
