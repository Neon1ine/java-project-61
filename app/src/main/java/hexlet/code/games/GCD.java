package hexlet.code.games;

import hexlet.code.Utils;

public final class GCD implements Game {
    private static final String INVITE = "Find the greatest common divisor of given numbers.";

    @Override
    public String getRules() {
        return INVITE;
    }

    @Override
    public String[] getData() {
        int first = Utils.getRandomNumber();
        int second = Utils.getRandomNumber();
        String[] result = new String[DATA_SIZE];
        result[0] = first + " " + second;
        result[1] = String.valueOf(findGCD(first, second));
        return result;
    }

    public int findGCD(int first, int second) {
        while (first != second) {
            if (first > second) {
                int temp = first;
                first = second;
                second = temp;
            }
            second -= first;
        }
        return first;
    }
}
