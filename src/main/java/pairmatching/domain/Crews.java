package pairmatching.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import pairmatching.constant.Course;
import pairmatching.constant.ErrorMessage;

public class Crews {

    private final List<Crew> crews;

    private Crews() {
        this.crews = new ArrayList<>();
    }

    public static Crews newInstance() {
        return new Crews();
    }

    public void registerCrews(List<String> crewNames, Course course) {
        for (String crewName : crewNames) {
            crews.add(Crew.from(crewName, course));
        }
    }

    public List<String> getCrewNames(Course course) {
        return crews.stream()
                .filter(crew -> crew.getCourse().equals(course))
                .map(Crew::getName).collect(Collectors.toList());
    }

    public Crew getCrew(String name) {
        return crews.stream()
                .filter(crew -> crew.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.INVALID_NAME.getErrorMessage()));
    }
}
