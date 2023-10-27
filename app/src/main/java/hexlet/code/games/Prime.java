package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public final class Prime implements Game {
    private static final int PRIME_NUMBER_RANGE = 20;
    private static final String INVITE = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";

    public Prime() {
        Engine.startGame(this);
    }

    @Override
    public String getRules() {
        return INVITE;
    }

    @Override
    public String[] createQuestionFindAnswer() {
        int number = Utils.generateRandomNumberInRange(1, PRIME_NUMBER_RANGE);
        return new String[]{String.valueOf(number), defineCorrectAnswer(number)};
    }

    public String defineCorrectAnswer(int number) {
        if (number == 1) {
            return "no";
        }
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return "no";
            }
        }
        return "yes";
    }
}
