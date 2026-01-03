package pairmatching.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import pairmatching.constant.Content;
import pairmatching.constant.Course;
import pairmatching.domain.Crews;
import pairmatching.domain.Matching;
import pairmatching.domain.Pair;

public class MatchingService {

    private static final int TRY_COUNT = 3;

    private final Crews crews;
    private final Matching matching;

    public MatchingService() {
        this.crews = Crews.newInstance();
        this.matching = Matching.newInstance();
    }

    public void registerFileInfo(List<String> crewNames, Course course) {
        crews.registerCrews(crewNames, course);
    }

    public boolean isAlreadyMatched(Content content) {
        return matching.isAlreadyMatched(content);
    }

    public boolean generateMatching(Content content) {
        List<String> crewNames = this.crews.getCrewNames(content.getCourse());

        for (int i = 0; i < TRY_COUNT; i++) {
            Deque<String> shuffleCrewNames = new ArrayDeque<>(Randoms.shuffle(crewNames));
            List<Pair> newPairs = new ArrayList<>();

            if (getSuccess(shuffleCrewNames, content, newPairs)) {
                return true;
            }
        }
        return false;
    }

    private boolean getSuccess(Deque<String> shuffleCrewNames, Content content, List<Pair> newPairs) {
        while (shuffleCrewNames.size() > 1) {
            Pair newPair = generatePair(shuffleCrewNames);

            if (pairAlreadyExists(content, newPair)) {
                return false;
            }

            newPairs.add(newPair);
        }

        matching.add(content, newPairs);
        return true;
    }

    private Pair generatePair(Deque<String> shuffleCrewNames) {
        String firstCrew = shuffleCrewNames.removeFirst();
        String secondCrew = shuffleCrewNames.removeFirst();
        String thirdCrew;

        if (shuffleCrewNames.size() == 1) {
            thirdCrew = shuffleCrewNames.removeFirst();
            return Pair.of(crews.getCrew(firstCrew), crews.getCrew(secondCrew), crews.getCrew(thirdCrew));
        }

        return Pair.of(crews.getCrew(firstCrew), crews.getCrew(secondCrew));
    }

    private boolean pairAlreadyExists(Content content, Pair newPair) {
        return matching.pairAlreadyExists(content, newPair);
    }

    public List<Pair> getMatching(Content content) {
        return matching.getMatching(content);
    }
}
