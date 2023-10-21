package hexlet.code.games;

import hexlet.code.Engine;

public class Prime {
    private static int number;
    private static final int PRIME_NUMBER_RANGE = 20;
    public static void startPrimeGame() {
        System.out.println("Answer 'yes' if given number is prime. Otherwise answer 'no'.");
        Engine.startGame(6);
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
}
