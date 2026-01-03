package pairmatching.constant;

import java.util.Arrays;

public enum Mission {

    RACING_CAR("자동차경주", Level.LEVEL1),
    LOTTO("로또", Level.LEVEL1),
    BASEBALL("숫자야구게임", Level.LEVEL1),

    SHOPPING_BAG("장바구니", Level.LEVEL2),
    PAYMENT("결제", Level.LEVEL2),
    SUBWAY("지하철노선도", Level.LEVEL2),

    IMPROVEMENT("성능개선", Level.LEVEL4),
    DEPLOYMENT("배포", Level.LEVEL4),

    NONE("", Level.NONE);

    private final String name;
    private final Level level;

    Mission(String name, Level level) {
        this.name = name;
        this.level = level;
    }

    public static Mission of(String name, Level level) {
        return Arrays.stream(values())
                .filter(mission -> mission.name.equals(name) && mission.level.equals(level))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.MISSION_ERROR.getErrorMessage()));
    }
}
