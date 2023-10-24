package hexlet.code.games;

import hexlet.code.Engine;

public final class Prime implements Game {
    private static int number;
    private static final int PRIME_NUMBER_RANGE = 20;
    private static final String INVITE = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";

    public Prime() {
        Engine.startGame(this);
    }

    public String getInvite() {
        return INVITE;
    }

    public String createQuestion() {
        number = Engine.generateRandomNumberInRange(1, PRIME_NUMBER_RANGE);
        return String.valueOf(number);
    }

    public String defineCorrectAnswer() {
        if (number == 1) {
            return "yes";
        }
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return "no";
            }
        }
        return "yes";
    }
}
