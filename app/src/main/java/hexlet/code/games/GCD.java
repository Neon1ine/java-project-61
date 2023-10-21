package hexlet.code.games;

import hexlet.code.Engine;

public class GCD {
    private static int first;
    private static int second;
    public static void startGCDGame() {
        System.out.println("Find the greatest common divisor of given numbers.");
        Engine.startGame(4);
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
