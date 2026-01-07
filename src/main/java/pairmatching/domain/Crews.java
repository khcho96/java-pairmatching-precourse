package pairmatching.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
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

    public List<String> getCrewNames(Course course) {
        return crews.stream()
                .filter(crew -> crew.getCourse().equals(course))
                .map(Crew::getName)
                .collect(Collectors.toList());
    }
}
