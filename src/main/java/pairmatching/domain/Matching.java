package pairmatching.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import pairmatching.constant.Course;
import pairmatching.constant.Level;
import pairmatching.constant.Mission;

public class Matching {

    private EnumMap<Course, EnumMap<Level, Map<Mission, List<Set<Crew>>>>> matching;

    public Matching() {
        this.matching = new EnumMap<>(Course.class);
        for (Course course : Course.values()) {
            matching.put(course, new EnumMap<>(Level.class));
            for (Level level : Level.values()) {
                matching.get(course).put(level, new HashMap<>());
                for (Mission mission : level.getMissions()) {
                    matching.get(course).get(level).put(mission, new ArrayList<>());
                }
            }
        }
    }

    public static Matching newInstance() {
        return new Matching();
    }

    public EnumMap<Course, EnumMap<Level, Map<Mission, List<Set<Crew>>>>> generateMatching(Crews crews, Course course,
                                                                                           Level level,
                                                                                           Mission mission) {

        List<?> raw = crews.getCrews(course);
        for (Object o : raw) {
            if (!(o instanceof Crew)) {
                throw new IllegalStateException(
                        "Crew 리스트에 Crew가 아닌 값이 있음: " + o + " / " + o.getClass()
                );
            }
        }

        for (int i = 0; i < 3; i++) {
            boolean check = true;
            int index = 0;
            List<Crew> shuffleCrew = Randoms.shuffle(crews.getCrews(course));
            while (index < shuffleCrew.size()) {
                Set<Crew> pair = new HashSet<>();

                pair.add(shuffleCrew.get(index++));
                pair.add(shuffleCrew.get(index++));
                if (index == shuffleCrew.size() - 1) {
                    pair.add(shuffleCrew.get(index++));
                }

                // 페어 검사
                if (isMatchedCrew(pair, level)) {
                    matching.get(course).get(level).get(mission).clear();
                    check = false;
                    break;
                }

                matching.get(course).get(level).get(mission).add(pair);
            }

            if (check) {
                for (Set<Crew> pair : matching.get(course).get(level).get(mission)) {
                    for (Crew crew : pair) {
                        Set<Crew> matchedCrews = new HashSet<>(pair);
                        matchedCrews.remove(crew);
                        crew.addMatchedCrews(matchedCrews, level);
                    }
                }
                break;
            }
        }
        return matching;
    }

    private boolean isMatchedCrew(Set<Crew> pair, Level level) {
        for (Crew crew : pair) {
            return crew.isMatchedCrew(pair, level);
        }
        return false;
    }

    public boolean isMatched(Course course, Level level, Mission mission) {
        if (matching.get(course).get(level).get(mission).isEmpty()) {
            return false;
        }
        return true;
    }

    public void delete(Course course, Level level, Mission mission) {
        matching.get(course).get(level).get(mission).clear();
    }
}
