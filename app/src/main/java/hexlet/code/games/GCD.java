package hexlet.code.games;

import hexlet.code.Engine;

public final class GCD implements Game {
    private static int first;
    private static int second;
    private static final String INVITE = "Find the greatest common divisor of given numbers.";

    public GCD() {
        Engine.startGame(this);
    }

    @Override
    public String getInvite() {
        return INVITE;
    }

    @Override
    public String createQuestion() {
        first = Engine.generateRandomNumber();
        second = Engine.generateRandomNumber();
        return first + " " + second;
    }

    @Override
    public String defineCorrectAnswer() {
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
