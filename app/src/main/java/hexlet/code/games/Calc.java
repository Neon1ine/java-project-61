package hexlet.code.games;

import hexlet.code.App;
import hexlet.code.Cli;
import hexlet.code.Engine;

public class Calc {
    private static String sign;
    private static int answer;

    public static void startCalcGame() {
        Cli.greeting();
        System.out.println("What is the result of the expression?");
        Engine.startGame(App.THIRD_OPTION);
    }

    public static String generateRandomOperation() {
        int operationIndex = (int) (Math.random() * 3);
        int first = Engine.generateRandomNumber();
        int second = Engine.generateRandomNumber();
        StringBuilder output = new StringBuilder();
        output.append(first).append(" ");
        switch (operationIndex) {
            case App.ZERO_OPTION:
                sign = "*";
                answer = first * second;
                break;
            case App.FIRST_OPTION:
                sign = "+";
                answer = first + second;
                break;
            case App.SECOND_OPTION:
                sign = "-";
                answer = first - second;
                break;
            default:
                System.out.println("Error in generateRandomOperation: "
                        + "wrong generateRandomOperation - " + operationIndex);
                break;
        }
        output.append(sign).append(" ").append(second);
        return String.valueOf(output);
    }

    public static String getAnswer() {
        return String.valueOf(answer);
    }
}
