package pairmatching.domain;

import java.util.ArrayList;
import java.util.List;
import pairmatching.constant.Course;

public class Crews {

    private final List<Crew> crews;

    private Crews() {
        this.crews = new ArrayList<>();
    }

    public static Crews newInstance() {
        return new Crews();
    }

    public void addCrew(String name, Course course) {
        crews.add(Crew.of(name, course));
    }
}
