package hexlet.code.games;

import hexlet.code.Engine;

public class Calc {
    private static String sign;
    private static int answer;

    public static void startCalcGame() {
        System.out.println("What is the result of the expression?");
        Engine.startGame(3);
    }

    public static String generateRandomOperation() {
        int operationIndex = (int) (Math.random() * 3);
        int first = Engine.generateRandomNumber();
        int second = Engine.generateRandomNumber();
        StringBuilder output = new StringBuilder();
        output.append(first).append(" ");
        switch (operationIndex) {
            case 0:
                sign = "*";
                answer = first * second;
                break;
            case 1:
                sign = "+";
                answer = first + second;
                break;
            case 2:
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
