package pairmatching.domain;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Set;
import pairmatching.constant.Course;
import pairmatching.constant.Level;

public class Crew {

    private final String name;
    private final Course course;
    private final EnumMap<Level, List<Crew>> matchedCrews;

    private Crew(String name, Course course) {
        this.name = name;
        this.course = course;
        matchedCrews = new EnumMap<>(Level.class);
        for (Level level : Level.values()) {
            matchedCrews.put(level, new ArrayList<>());
        }
    }

    public static Crew of(String name, Course course) {
        return new Crew(name, course);
    }

    public void addMatchedCrews(Set<Crew> matchedCrews, Level level) {
        this.matchedCrews.get(level).addAll(new ArrayList<>(matchedCrews));
    }

    public boolean isMatchedCrew(Set<Crew> pair, Level level) {
        return pair.stream()
                .anyMatch(crew -> matchedCrews.get(level).contains(crew));
    }

    @Override
    public String toString() {
        return name;
    }
}
