package hexlet.code;

public class Utils {
    private static final int RANDOM_GENERATOR_RANGE = 100;

    public static int generateRandomNumberInRange(int first, int last) {
        return (int) (first + Math.random() * last);
    }

    public static int generateRandomNumber() {
        return (int) (Math.random() * RANDOM_GENERATOR_RANGE);
    }

}
