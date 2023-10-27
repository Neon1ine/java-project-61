package hexlet.code.games;

import hexlet.code.Utils;

public final class Progression implements Game {
    private static final int LENGTH_RANGE = 10;
    private static final int MIN_LENGTH = 5;
    private static final int STEP_RANGE = 10;
    private static final int MIN_STEP = 2;
    private static final String INVITE = "What number is missing in the progression?";

    @Override
    public String getRules() {
        return INVITE;
    }

    @Override
    public String[] getData() {
        int length = MIN_LENGTH + Utils.getRandomNumber(0, LENGTH_RANGE);
        int step = Utils.getRandomNumber(MIN_STEP, STEP_RANGE);
        int[] fullProgression = new int[length];
        int first = Utils.getRandomNumber();
        fullProgression[0] = first;
        for (int i = 1; i < length; i++) {
            fullProgression[i] = fullProgression[i - 1] + step;
        }
        int deletedElementInd = Utils.getRandomNumber(0, length);
        int missingNumber = fullProgression[deletedElementInd];
        String output = castProgressionIntoString(fullProgression, missingNumber);
        return new String[]{String.valueOf(output), String.valueOf(missingNumber)};
    }

    private String castProgressionIntoString(int[] arr, int missingNumber) {
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
}
