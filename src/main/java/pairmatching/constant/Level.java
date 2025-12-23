package pairmatching.constant;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum Level {
    LEVEL1("레벨1", Arrays.asList(Mission.RACING_CAR, Mission.LOTTO, Mission.BASEBALL)),
    LEVEL2("레벨2", Arrays.asList(Mission.SHOPPING_BAG, Mission.PAY, Mission.SUBWAY)),
    LEVEL3("레벨3", Collections.emptyList()),
    LEVEL4("레벨4", Arrays.asList(Mission.IMPROVEMENT, Mission.DEPLOYMENT)),
    LEVEL5("레벨5", Collections.emptyList());

    private final String name;
    private final List<Mission> missions;

    Level(String name, List<Mission> missions) {
        this.name = name;
        this.missions = missions;
    }

    public static Level fromName(String name) {
        return Arrays.stream(values())
                .filter(level -> level.name.equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.INVALID_LEVEL_ERROR.getErrorMessage()));
    }

    public Mission missionFromName(String missionName) {
        if (missions.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY_MISSION_ERROR.getErrorMessage());
        }

        return Mission.fromName(missionName);
    }

    public List<Mission> getMissions() {
        return missions;
    }
}
