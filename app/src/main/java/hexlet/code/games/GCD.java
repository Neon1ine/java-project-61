package hexlet.code.games;

import hexlet.code.Cli;
import hexlet.code.Engine;
import hexlet.code.Menu;

public class GCD {
    private static int first;
    private static int second;
    public static void startGCDGame() {
        Cli.greeting();
        System.out.println("Find the greatest common divisor of given numbers.");
        Engine.startGame(Menu.FOURTH_OPTION);
    }

    public static String findGCD() {
        while (first != second) {
            if (first > second) {
                int temp = first;
                first = second;
                second = temp;
            }
            second -= first;
        }
        return String.valueOf(first);
    }

    public static String generate2Numbers() {
        first = Engine.generateRandomNumber();
        second = Engine.generateRandomNumber();
        return first + " " + second;
    }
}
