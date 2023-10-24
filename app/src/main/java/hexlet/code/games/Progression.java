package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Menu;

public class Progression {
    private static final int PROGRESSION_LENGTH_RANGE = 10;
    private static final int PROGRESSION_LENGTH_MIN_VALUE = 5;
    private static final int PROGRESSION_STEP_RANGE = 10;
    private static final int PROGRESSION_STEP_MIN_VALUE = 2;
    private static int missingNumber;
    private static final String invite = "What number is missing in the progression?";

    public static void start() {
        Engine.startGame(Menu.FIFTH_OPTION);
    }

    public static String generateProgression() {
        int[] fullProgression = new int[PROGRESSION_LENGTH_MIN_VALUE
                + Engine.generateRandomNumberInRange(0, PROGRESSION_LENGTH_RANGE)];
        int step = Engine.generateRandomNumberInRange(PROGRESSION_STEP_MIN_VALUE, PROGRESSION_STEP_RANGE);
        int element = Engine.generateRandomNumber();
        fullProgression[0] = element;
        for (int i = 1; i < fullProgression.length; i++) {
            fullProgression[i] = fullProgression[i - 1] + step;
        }
        int deletedElementInd = Engine.generateRandomNumberInRange(0, fullProgression.length);
        missingNumber = fullProgression[deletedElementInd];
        String output = castProgressionIntoString(fullProgression);
        return String.valueOf(output);
    }

    private static String castProgressionIntoString(int[] arr) {
        StringBuilder output = new StringBuilder();
        for (int element : arr) {
            if (element != missingNumber) {
                output.append(element).append(" ");
            } else {
                output.append(".. ");
            }
        }
        return String.valueOf(output);
    }

    public static String getMissingNumber() {
        return String.valueOf(missingNumber);
    }

    public static String getInvite() {
        return invite;
    }
}
