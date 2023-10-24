package hexlet.code.games;

import hexlet.code.Cli;
import hexlet.code.Engine;
import hexlet.code.Menu;

public class Even {
    private static int number;
    public static void startEvenGame() {
        Cli.greeting();
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");
        Engine.startGame(Menu.SECOND_OPTION);
    }

    public static String isEven() {
        return (number % 2 == 0) ? "yes" : "no";
    }

    public static String generateRandomNumberAsQuestion() {
        number = Engine.generateRandomNumber();
        return String.valueOf(number);
    }
}
