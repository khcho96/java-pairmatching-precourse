package pairmatching.constant;

import java.util.Arrays;

public enum Content {

    BACKEND_LEVEL1_RACING_CAR(Course.BACKEND, Level.LEVEL1, Mission.RACING_CAR),
    BACKEND_LEVEL1_LOTTO(Course.BACKEND, Level.LEVEL1, Mission.LOTTO),
    BACKEND_LEVEL1_BASEBALL(Course.BACKEND, Level.LEVEL1, Mission.BASEBALL),
    BACKEND_LEVEL2_SHOPPING(Course.BACKEND, Level.LEVEL2, Mission.SHOPPING),
    BACKEND_LEVEL2_PAY(Course.BACKEND, Level.LEVEL2, Mission.PAY),
    BACKEND_LEVEL2_SUBWAY(Course.BACKEND, Level.LEVEL2, Mission.SUBWAY),
    BACKEND_LEVEL2_IMPROVEMENT(Course.BACKEND, Level.LEVEL4, Mission.IMPROVEMENT),
    BACKEND_LEVEL2_DEPLOYMENT(Course.BACKEND, Level.LEVEL4, Mission.DEPLOYMENT),

    FRONTEND_LEVEL1_RACING_CAR(Course.FRONTEND, Level.LEVEL1, Mission.RACING_CAR),
    FRONTEND_LEVEL1_LOTTO(Course.FRONTEND, Level.LEVEL1, Mission.LOTTO),
    FRONTEND_LEVEL1_BASEBALL(Course.FRONTEND, Level.LEVEL1, Mission.BASEBALL),
    FRONTEND_LEVEL2_SHOPPING(Course.FRONTEND, Level.LEVEL2, Mission.SHOPPING),
    FRONTEND_LEVEL2_PAY(Course.FRONTEND, Level.LEVEL2, Mission.PAY),
    FRONTEND_LEVEL2_SUBWAY(Course.FRONTEND, Level.LEVEL2, Mission.SUBWAY),
    FRONTEND_LEVEL2_IMPROVEMENT(Course.FRONTEND, Level.LEVEL4, Mission.IMPROVEMENT),
    FRONTEND_LEVEL2_DEPLOYMENT(Course.FRONTEND, Level.LEVEL4, Mission.DEPLOYMENT),

    NONE(null, null, null);

    private final Course course;
    private final Level level;
    private final Mission mission;

    Content(Course course, Level level, Mission mission) {
        this.course = course;
        this.level = level;
        this.mission = mission;
    }

    public static Content from(Course course, Level level, Mission mission) {
        return Arrays.stream(values())
                .filter(content -> content.course.equals(course) && content.level.equals(level) && content.mission.equals(mission))
                .findFirst()
                .orElse(NONE);
    }
}
