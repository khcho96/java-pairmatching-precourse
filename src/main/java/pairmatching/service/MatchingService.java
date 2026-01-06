package pairmatching.service;

import java.util.List;
import pairmatching.constant.Course;
import pairmatching.domain.Crews;

public class MatchingService {

    private final Crews crews;

    public MatchingService() {
        this.crews = Crews.newInstance();
    }

    public void registerFileInfo(List<String> names, Course course) {
        for (String name : names) {
            crews.addCrew(name, course);
        }
    }
}
