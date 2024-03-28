package nextstep.ladder.data;

import java.util.Arrays;

public enum StepType {
    EMPTY(false, "     "),
    STEP(true, "-----");

    private final boolean value;
    private final String draw;

    StepType(boolean value, String draw) {
        this.value = value;
        this.draw = draw;
    }

    public static StepType of(boolean value) {
        return Arrays.stream(StepType.values())
                .filter(stepType -> stepType.value == value)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    public static String drawOf(StepType value) {
        return Arrays.stream(StepType.values())
                .filter(stepType -> stepType == value)
                .map(stepType -> stepType.draw)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}