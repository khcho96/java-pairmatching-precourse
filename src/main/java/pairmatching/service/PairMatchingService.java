package pairmatching.service;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import pairmatching.constant.Course;
import pairmatching.constant.Level;
import pairmatching.constant.Mission;
import pairmatching.domain.Crew;
import pairmatching.domain.Crews;
import pairmatching.domain.Matching;

public class PairMatchingService {

    private final Crews crews;
    private final Matching matching;

    public PairMatchingService() {
        crews = Crews.newInstance();
        matching = Matching.newInstance();
    }

    public void setCrews(List<String> backendCrews, List<String> frontendCrews) {
        for (String backendCrew : backendCrews) {
            crews.addCrew(backendCrew, Course.BACKEND);
        }
        for (String frontendCrew : frontendCrews) {
            crews.addCrew(frontendCrew, Course.FRONTEND);
        }
    }

    public EnumMap<Course, EnumMap<Level, Map<Mission, List<Set<Crew>>>>> makeMatching(List<String> contents) {
        Course course = Course.fromName(contents.get(0));
        Level level = Level.fromName(contents.get(1));
        Mission mission = level.missionFromName(contents.get(2));

        return matching.generateMatching(crews, course, level, mission);
    }

    public boolean isMatched(List<String> contents) {
        Course course = Course.fromName(contents.get(0));
        Level level = Level.fromName(contents.get(1));
        Mission mission = level.missionFromName(contents.get(2));

        return matching.isMatched(course, level, mission);
    }

    public void delete(List<String> contents) {
        Course course = Course.fromName(contents.get(0));
        Level level = Level.fromName(contents.get(1));
        Mission mission = level.missionFromName(contents.get(2));

        matching.delete(course, level, mission);
    }
}
