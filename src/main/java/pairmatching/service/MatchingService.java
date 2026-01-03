package pairmatching.service;

import java.util.List;
import pairmatching.constant.Course;
import pairmatching.domain.Crews;
import pairmatching.domain.Matching;

public class MatchingService {

    private final Crews crews;
    private final Matching matching;

    public MatchingService() {
        this.crews = Crews.newInstance();
        this.matching = Matching.newInstance();
    }

    public void registerFileInfo(List<String> crewNames, Course course) {
        crews.registerCrews(crewNames, course);
    }
}
