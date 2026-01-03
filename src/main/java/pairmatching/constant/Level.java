package pairmatching.constant;

import java.util.Arrays;

public enum Level {

    LEVEL1("레벨1"),
    LEVEL2("레벨2"),
    LEVEL3("레벨3"),
    LEVEL4("레벨4"),
    LEVEL5("레벨5"),
    NONE("");

    private final String name;

    Level(String name) {
        this.name = name;
    }

    public static Level fromName(String name) {
        return Arrays.stream(values())
                .filter(mission -> mission.name.equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.LEVEL_ERROR.getErrorMessage()));
    }
}
