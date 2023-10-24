package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Menu;

public class Calc {
    private static final int THREE_OPERATIONS = 3;
    private static String sign;
    private static int answer;
    private static final String invite = "What is the result of the expression?";

    public static void start() {
        Engine.startGame(Menu.THIRD_OPTION);
    }

    public static String generateRandomOperation() {
        int operationIndex = (int) (Math.random() * THREE_OPERATIONS);
        int first = Engine.generateRandomNumber();
        int second = Engine.generateRandomNumber();
        StringBuilder output = new StringBuilder();
        output.append(first).append(" ");
        switch (operationIndex) {
            case Menu.ZERO_OPTION:
                sign = "*";
                answer = first * second;
                break;
            case Menu.FIRST_OPTION:
                sign = "+";
                answer = first + second;
                break;
            case Menu.SECOND_OPTION:
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

    public static String getInvite() {
        return invite;
    }
}
