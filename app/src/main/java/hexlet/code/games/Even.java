package hexlet.code.games;

import hexlet.code.Engine;

public class Even {
    public static void startEvenGame(String username) {
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");
        Engine.startGame(2, username);
    }

    public static String findIsEven(String question) {
        int number = Integer.parseInt(question);
        return (number % 2 == 0) ? "yes" : "no";
    }

}
