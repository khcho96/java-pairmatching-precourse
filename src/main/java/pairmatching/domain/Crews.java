package pairmatching.domain;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import pairmatching.constant.Course;

public class Crews {

    private final EnumMap<Course, List<Crew>> crews;

    private Crews() {
        this.crews = new EnumMap<>(Course.class);
        crews.put(Course.BACKEND, new ArrayList<>());
        crews.put(Course.FRONTEND, new ArrayList<>());
    }

    public static Crews newInstance() {
        return new Crews();
    }

    public void addCrew(String name, Course course) {
        crews.get(course).add(Crew.of(name, course));
    }

    public List<Crew> getCrews(Course course) {
        return new ArrayList<>(crews.get(course));
    }
}
