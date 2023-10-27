package hexlet.code.games;

import hexlet.code.Utils;

public final class Calc implements Game {
    private static final String[] OPERATIONS = {"*", "+", "-"};
    private static final String INVITE = "What is the result of the expression?";

    @Override
    public String getRules() {
        return INVITE;
    }

    @Override
    public String[] getData() {
        int operationIndex = (int) (Math.random() * OPERATIONS.length);
        int first = Utils.getRandomNumber();
        int second = Utils.getRandomNumber();
        int answer = 0;
        StringBuilder output = new StringBuilder();
        output.append(first).append(" ");
        switch (OPERATIONS[operationIndex]) {
            case "*":
                answer = first * second;
                break;
            case "+":
                answer = first + second;
                break;
            case "-":
                answer = first - second;
                break;
            default:
                System.out.println("Error in generateRandomOperation: "
                        + "wrong generateRandomOperation - " + operationIndex);
                System.exit(0);
                break;
        }
        output.append(OPERATIONS[operationIndex]).append(" ").append(second);
        return new String[]{String.valueOf(output) , String.valueOf(answer)};
    }
}
