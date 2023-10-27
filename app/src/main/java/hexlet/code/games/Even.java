package hexlet.code.games;

import hexlet.code.Utils;

public final class Even implements Game {
    private static final String INVITE = "Answer 'yes' if the number is even, otherwise answer 'no'.";

    @Override
    public String getRules() {
        return INVITE;
    }

    @Override
    public String[] getData() {
        int number = Utils.getRandomNumber();
        String[] result = new String[DATA_SIZE];
        result[0] = String.valueOf(number);
        result[1] = isEven(number) ? "yes" : "no";
        return result;
    }

    private boolean isEven(int number) {
        return number % 2 == 0;
    }

}
