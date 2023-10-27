package hexlet.code.games;

import hexlet.code.Engine;

public final class Calc implements Game {
    private static final int OPERATION_MULTIPLICATION = 0;
    private static final int OPERATION_PLUS = 1;
    private static final int FINAL_OPERATION_MINIS = 2;
    private static String sign;
    private static int answer;
    private static final String INVITE = "What is the result of the expression?";

    public Calc() {
        Engine.startGame(this);
    }

    public String getRules() {
        return INVITE;
    }

    public String createQuestion() {
        int operationIndex = (int) (Math.random() * FINAL_OPERATION_MINIS + 1);
        int first = Engine.generateRandomNumber();
        int second = Engine.generateRandomNumber();
        StringBuilder output = new StringBuilder();
        output.append(first).append(" ");
        switch (operationIndex) {
            case OPERATION_MULTIPLICATION:
                sign = "*";
                answer = first * second;
                break;
            case OPERATION_PLUS:
                sign = "+";
                answer = first + second;
                break;
            case FINAL_OPERATION_MINIS:
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

    public String defineCorrectAnswer() {
        return String.valueOf(answer);
    }
}
