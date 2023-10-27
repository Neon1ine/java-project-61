package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public final class Progression implements Game {
    private static final int PROGRESSION_LENGTH_RANGE = 10;
    private static final int PROGRESSION_LENGTH_MIN_VALUE = 5;
    private static final int PROGRESSION_STEP_RANGE = 10;
    private static final int PROGRESSION_STEP_MIN_VALUE = 2;
    private static final String INVITE = "What number is missing in the progression?";

    public Progression() {
        Engine.startGame(this);
    }

    @Override
    public String getRules() {
        return INVITE;
    }

    @Override
    public String[] createQuestionFindAnswer() {
        int[] fullProgression = new int[PROGRESSION_LENGTH_MIN_VALUE
                + Utils.generateRandomNumberInRange(0, PROGRESSION_LENGTH_RANGE)];
        int step = Utils.generateRandomNumberInRange(PROGRESSION_STEP_MIN_VALUE, PROGRESSION_STEP_RANGE);
        int element = Utils.generateRandomNumber();
        fullProgression[0] = element;
        for (int i = 1; i < fullProgression.length; i++) {
            fullProgression[i] = fullProgression[i - 1] + step;
        }
        int deletedElementInd = Utils.generateRandomNumberInRange(0, fullProgression.length);
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
