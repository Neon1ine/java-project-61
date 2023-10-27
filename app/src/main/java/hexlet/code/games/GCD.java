package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public final class GCD implements Game {
    private static final String INVITE = "Find the greatest common divisor of given numbers.";

    public GCD() {
        Engine.startGame(this);
    }

    @Override
    public String getRules() {
        return INVITE;
    }

    @Override
    public String[] createQuestionFindAnswer() {
        int first = Utils.generateRandomNumber();
        int second = Utils.generateRandomNumber();
        return new String[]{first + " " + second, defineCorrectAnswer(first, second)};
    }

    public String defineCorrectAnswer(int first, int second) {
        while (first != second) {
            if (first > second) {
                int temp = first;
                first = second;
                second = temp;
            }
            second -= first;
        }
        return String.valueOf(first);
    }
}
