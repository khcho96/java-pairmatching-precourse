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

    public void registerCrews(List<String> crewNames, Course course) {
        for (String crewName : crewNames) {
            crews.add(Crew.from(crewName, course));
        }
    }

    public List<Crew> getBackEndCrews() {
        return new ArrayList<>(crews.stream()
                .filter(crew -> crew.getCourse().equals(Course.BACKEND))
                .toList());
    }

    public List<Crew> getFrontEndCrews() {
        return new ArrayList<>(crews.stream()
                .filter(crew -> crew.getCourse().equals(Course.FRONTEND))
                .toList());
    }
}
