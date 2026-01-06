package pairmatching.constant;

import java.util.Arrays;

public enum Content {

    BACKEND_LEVEL1_RACING_CAR(Course.BACKEND, Level.LEVEL1, Mission.RACING_CAR),
    BACKEND_LEVEL1_LOTTO(Course.BACKEND, Level.LEVEL1, Mission.LOTTO),
    BACKEND_LEVEL1_BASEBALL(Course.BACKEND, Level.LEVEL1, Mission.BASEBALL),
    BACKEND_LEVEL2_SHOPPING_BAG(Course.BACKEND, Level.LEVEL2, Mission.SHOPPING_BAG),
    BACKEND_LEVEL2_PAYMENT(Course.BACKEND, Level.LEVEL2, Mission.PAYMENT),
    BACKEND_LEVEL2_SUBWAY(Course.BACKEND, Level.LEVEL2, Mission.SUBWAY),
    BACKEND_LEVEL4_IMPROVEMENT(Course.BACKEND, Level.LEVEL4, Mission.IMPROVEMENT),
    BACKEND_LEVEL4_DEPLOYMENT(Course.BACKEND, Level.LEVEL4, Mission.DEPLOYMENT),

    FRONTEND_LEVEL1_RACING_CAR(Course.FRONTEND, Level.LEVEL1, Mission.RACING_CAR),
    FRONTEND_LEVEL1_LOTTO(Course.FRONTEND, Level.LEVEL1, Mission.LOTTO),
    FRONTEND_LEVEL1_BASEBALL(Course.FRONTEND, Level.LEVEL1, Mission.BASEBALL),
    FRONTEND_LEVEL2_SHOPPING_BAG(Course.FRONTEND, Level.LEVEL2, Mission.SHOPPING_BAG),
    FRONTEND_LEVEL2_PAYMENT(Course.FRONTEND, Level.LEVEL2, Mission.PAYMENT),
    FRONTEND_LEVEL2_SUBWAY(Course.FRONTEND, Level.LEVEL2, Mission.SUBWAY),
    FRONTEND_LEVEL4_IMPROVEMENT(Course.FRONTEND, Level.LEVEL4, Mission.IMPROVEMENT),
    FRONTEND_LEVEL4_DEPLOYMENT(Course.FRONTEND, Level.LEVEL4, Mission.DEPLOYMENT),

    NONE(Course.NONE, Level.NONE, Mission.NONE)
    ;

    private final Course course;
    private final Level level;
    private final Mission mission;

    Content(Course course, Level level, Mission mission) {
        this.course = course;
        this.level = level;
        this.mission = mission;
    }

    public static Content of(Course course, Level level, Mission mission) {
        return Arrays.stream(values())
                .filter(content -> isMatch(course, level, mission, content))
                .findFirst()
                .orElse(NONE);
    }

    private static boolean isMatch(Course course, Level level, Mission mission, Content content) {
        return content.course.equals(course) && content.level.equals(level) && content.mission.equals(mission);
    }

    public Course getCourse() {
        return course;
    }

    public Level getLevel() {
        return level;
    }

    public Mission getMission() {
        return mission;
    }
}
