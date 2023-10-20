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

    public static String calculateAnswer(String question) {
        int a = 0;
        int b = 0;
        char sign = 0;

        for (int i = 0; i < question.length(); i++) {
            char ch = question.charAt(i);
            if (Character.isDigit(ch)) {
                if (i < 2) {
                    a = a * 10 + Character.getNumericValue(ch);
                } else {
                    b = b * 10 + Character.getNumericValue(ch);
                }
            } else if (ch == 42 || ch == 43 || ch == 45) {
                sign = ch;
            }
        }

        return String.valueOf(findOperationAnswer(a, b, sign));
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
                System.out.println("Error in calculateAnswer: wrong operation - " + (int) sign);
        }
        return result;
    }
}
