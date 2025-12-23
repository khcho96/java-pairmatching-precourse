package pairmatching.view;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import pairmatching.constant.Course;
import pairmatching.constant.Level;
import pairmatching.constant.Mission;
import pairmatching.domain.Crew;

public class OutputView {

    private static final String NEW_LINE = System.lineSeparator();
    private static final String _MESSAGE = "";


    public static void printErrorMessage(IllegalArgumentException e) {
        System.out.println(e.getMessage());
    }

    public static void printMatching(EnumMap<Course, EnumMap<Level, Map<Mission, List<Set<Crew>>>>> matching,
                                     List<String> contents) {
        Course course = Course.fromName(contents.get(0));
        Level level = Level.fromName(contents.get(1));
        Mission mission = level.missionFromName(contents.get(2));
        System.out.println("페어 매칭 결과입니다.");
        List<Set<Crew>> pairs = matching.get(course).get(level).get(mission);

        for (Set<Crew> pair : pairs) {
            String[] array = pair.stream()
                    .map(Object::toString)
                    .toArray(String[]::new);
            System.out.println(String.join(" : ", array));
        }
    }
}
