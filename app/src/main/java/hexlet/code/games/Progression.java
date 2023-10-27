package hexlet.code.games;

import hexlet.code.Engine;

public final class Progression implements Game {
    private static final int PROGRESSION_LENGTH_RANGE = 10;
    private static final int PROGRESSION_LENGTH_MIN_VALUE = 5;
    private static final int PROGRESSION_STEP_RANGE = 10;
    private static final int PROGRESSION_STEP_MIN_VALUE = 2;
    private static int missingNumber;
    private static final String INVITE = "What number is missing in the progression?";

    public Progression() {
        Engine.startGame(this);
    }

    public String getRules() {
        return INVITE;
    }

    public String createQuestion() {
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

    public String defineCorrectAnswer() {
        return String.valueOf(missingNumber);
    }

    private String castProgressionIntoString(int[] arr) {
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
