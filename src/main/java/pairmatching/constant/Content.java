package pairmatching.constant;

import java.util.Arrays;

public enum Content {

    CONTENT1(Course.BACKEND, Level.LEVEL1, Mission.RACING_CAR),
    CONTENT2(Course.BACKEND, Level.LEVEL1, Mission.LOTTO),
    CONTENT3(Course.BACKEND, Level.LEVEL1, Mission.BASEBALL),
    CONTENT4(Course.BACKEND, Level.LEVEL2, Mission.SHOPPING_BAG),
    CONTENT5(Course.BACKEND, Level.LEVEL2, Mission.PAYMENT),
    CONTENT6(Course.BACKEND, Level.LEVEL2, Mission.SUBWAY),
    CONTENT7(Course.BACKEND, Level.LEVEL4, Mission.IMPROVEMENT),
    CONTENT8(Course.BACKEND, Level.LEVEL4, Mission.DEPLOYMENT),

    CONTENT9(Course.FRONTEND, Level.LEVEL1, Mission.RACING_CAR),
    CONTENT10(Course.FRONTEND, Level.LEVEL1, Mission.LOTTO),
    CONTENT11(Course.FRONTEND, Level.LEVEL1, Mission.BASEBALL),
    CONTENT12(Course.FRONTEND, Level.LEVEL2, Mission.SHOPPING_BAG),
    CONTENT13(Course.FRONTEND, Level.LEVEL2, Mission.PAYMENT),
    CONTENT14(Course.FRONTEND, Level.LEVEL2, Mission.SUBWAY),
    CONTENT15(Course.FRONTEND, Level.LEVEL4, Mission.IMPROVEMENT),
    CONTENT16(Course.FRONTEND, Level.LEVEL4, Mission.DEPLOYMENT),

    NONE(null, null, null)
    ;

    private final Course course;
    private final Level level;
    private final Mission mission;

    Content(Course course, Level level, Mission mission) {
        this.course = course;
        this.level = level;
        this.mission = mission;
    }

    public static Content fromName(Course course, Level level, Mission mission) {
        return Arrays.stream(values())
                .filter(content -> isMatch(course, level, mission, content))
                .findFirst()
                .orElse(NONE);
    }

    private static boolean isMatch(Course course, Level level, Mission mission, Content content) {
        return content.course.equals(course) && content.level.equals(level) && content.mission.equals(mission);
    }
}
