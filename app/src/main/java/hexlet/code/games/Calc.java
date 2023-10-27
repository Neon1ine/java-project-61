package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public final class Calc implements Game {
    private static final int OPERATION_MULTIPLICATION = 0;
    private static final int OPERATION_PLUS = 1;
    private static final int FINAL_OPERATION_MINIS = 2;
    private static final String INVITE = "What is the result of the expression?";

    public Calc() {
        Engine.startGame(this);
    }

    @Override
    public String getRules() {
        return INVITE;
    }

    @Override
    public String[] createQuestionFindAnswer() {
        int operationIndex = (int) (Math.random() * FINAL_OPERATION_MINIS + 1);
        int first = Utils.generateRandomNumber();
        int second = Utils.generateRandomNumber();
        String sign = null;
        int answer = 0;
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
        return new String[]{String.valueOf(output) , String.valueOf(answer)};
    }
}
