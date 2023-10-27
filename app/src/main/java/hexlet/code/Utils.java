package hexlet.code;

public class Utils {
    private static final int RANDOM_GENERATOR_RANGE = 100;

    public static int getRandomNumber(int first, int last) {
        return (int) (first + Math.random() * last);
    }

    public static int getRandomNumber() {
        return (int) (Math.random() * RANDOM_GENERATOR_RANGE);
    }

}
