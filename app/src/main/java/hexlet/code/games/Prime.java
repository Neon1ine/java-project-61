package hexlet.code.games;

import hexlet.code.Utils;

public final class Prime implements Game {
    private static final int PRIME_NUMBER_RANGE = 20;
    private static final String INVITE = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";

    @Override
    public String getRules() {
        return INVITE;
    }

    @Override
    public String[] getData() {
        int number = Utils.getRandomNumber(1, PRIME_NUMBER_RANGE);
        String[] result = new String[DATA_SIZE];
        result[0] = String.valueOf(number);
        result[1] = isPrime(number) ? "yes" : "no";
        return result;
    }

    public boolean isPrime(int number) {
        if (number == 1) {
            return false;
        }
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
