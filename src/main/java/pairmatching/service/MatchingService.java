package pairmatching.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import pairmatching.constant.Content;
import pairmatching.constant.Course;
import pairmatching.domain.Crew;
import pairmatching.domain.Crews;
import pairmatching.domain.Matching;
import pairmatching.domain.Pair;

public class MatchingService {

    private final Crews crews;
    private final Matching matching;

    public MatchingService() {
        crews = Crews.newInstance();
        matching = new Matching();
    }

    public void registerFileInfo(List<String> names, Course course) {
        for (String name : names) {
            crews.addCrew(name, course);
        }
    }

    public boolean MatchingExists(Content content) {
        return matching.isMatchingExists(content);
    }

    public boolean tryMatching(Content content) {
        List<String> crewNames = crews.getCrewNames(content.getCourse());
        for (int i = 0; i < 3; i++) {
            Deque<String> shuffleCrewNames = new ArrayDeque<>(Randoms.shuffle(crewNames));

            if (isSuccess(shuffleCrewNames, content)) {
                return true;
            }
        }
        return false;
    }

    private boolean isSuccess(Deque<String> shuffleCrewNames, Content content) {
        List<Pair> pairs = new ArrayList<>();

        while (shuffleCrewNames.size() > 1) {
            if (MatchingIsFailure(shuffleCrewNames, content, pairs)) {
                return false;
            }
        }

        matching.addPairs(pairs, content);
        return true;
    }

    private boolean MatchingIsFailure(Deque<String> shuffleCrewNames, Content content, List<Pair> pairs) {
        Crew crew1 = Crew.of(shuffleCrewNames.removeFirst(), content.getCourse());
        Crew crew2 = Crew.of(shuffleCrewNames.removeFirst(), content.getCourse());
        Crew crew3;
        if (shuffleCrewNames.size() == 1) {
            crew3 = Crew.of(shuffleCrewNames.removeFirst(), content.getCourse());
            if (!matching.isValidPair(content, crew1, crew2, crew3)) {
                return true;
            }
            pairs.add(new Pair(crew1, crew2, crew3));
        }

        if (!matching.isValidPair(content, crew1, crew2)) {
            return true;
        }
        pairs.add(new Pair(crew1, crew2));

        return false;
    }

    public List<Pair> getMatching(Content content) {
        return matching.getMatching(content);
    }
}
