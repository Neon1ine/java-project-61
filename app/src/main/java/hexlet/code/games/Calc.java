package hexlet.code.games;

import hexlet.code.Engine;

public class Calc {
    public static void startCalcGame(String username) {
        System.out.println("What is the result of the expression?");
        Engine.startGame(3, username);
    }

    public static String generateRandomOperation() {
        int operationIndex = (int) (Math.random() * 3);
        StringBuffer output = new StringBuffer();
        output.append(Engine.generateRandomNumber()).append(" ");
        switch (operationIndex) {
            case 0:
                output.append("*");
                break;
            case 1:
                output.append("+");
                break;
            case 2:
                output.append("-");
                break;
            default:
                System.out.println("Error in generateRandomOperation: "
                        + "wrong generateRandomOperation - " + operationIndex);
                break;
        }
        output.append(" ").append(Engine.generateRandomNumber());
        return String.valueOf(output);
    }

    public static String findOperandsAndSign(String question) {
        int a = Engine.findOperand(question, true);
        int b = Engine.findOperand(question, false);
        char sign = findSymbolInOperation(question);

        return String.valueOf(findOperationAnswer(a, b, sign));
    }

    private static char findSymbolInOperation(String question) {
        for (int i = 2; i < question.length() - 2; i++) {
            char ch = question.charAt(i);
            if (ch == 42 || ch == 43 || ch == 45) {
                return ch;
            }
        }
        return 0;
    }

    private static int findOperationAnswer(int a, int b, char sign) {
        int result = 0;
        switch ((int) sign) {
            case 42:
                result = a * b;
                break;
            case 43:
                result = a + b;
                break;
            case 45:
                result = a - b;
                break;
            default:
                System.out.println("Error in findOperationAnswer: wrong operation - " + (int) sign);
        }
        return result;
    }
}
