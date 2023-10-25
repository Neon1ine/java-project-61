package hexlet.code.games;

import hexlet.code.Engine;

public final class Even implements Game {
    private static int number;
    private static final String INVITE = "Answer 'yes' if the number is even, otherwise answer 'no'.";

    public Even() {
        Engine.startGame(this);
    }

    @Override
    public String getInvite() {
        return INVITE;
    }

    @Override
    public String createQuestion() {
        number = Engine.generateRandomNumber();
        return String.valueOf(number);
    }

    @Override
    public String defineCorrectAnswer() {
        return (number % 2 == 0) ? "yes" : "no";
    }

}
