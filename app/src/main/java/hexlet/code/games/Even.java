package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public final class Even implements Game {
    private static final String INVITE = "Answer 'yes' if the number is even, otherwise answer 'no'.";

    public Even() {
        Engine.startGame(this);
    }

    @Override
    public String getRules() {
        return INVITE;
    }

    @Override
    public String[] createQuestionFindAnswer() {
        int number = Utils.generateRandomNumber();
        return new String[]{String.valueOf(number), defineCorrectAnswer(number)};
    }

    public String defineCorrectAnswer(int number) {
        return (number % 2 == 0) ? "yes" : "no";
    }

}
