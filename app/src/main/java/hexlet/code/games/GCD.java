package hexlet.code.games;

import hexlet.code.Engine;

public class GCD {
    public static void startGCDGame(String username) {
        System.out.println("Find the greatest common divisor of given numbers.");
        Engine.startGame(4, username);
    }

    public static String findGCD(String question) {
        int a = Engine.findOperand(question, true);
        int b = Engine.findOperand(question, false);
        while (a != b) {
            if (a > b) {
                int temp = a;
                a = b;
                b = temp;
            }
            b -= a;
        }

        return String.valueOf(a);
    }
}
