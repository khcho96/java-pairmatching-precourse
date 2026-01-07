package pairmatching.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import pairmatching.constant.Content;

public class Matching {

    private final Map<Content, List<Pair>> matching;

    public Matching() {
        matching = new HashMap<>();
        for (Content content : Content.values()) {
            matching.put(content, new ArrayList<>());
        }
        matching.remove(Content.NONE);
    }

    public boolean isMatchingExists(Content content) {
        return !matching.get(content).isEmpty();
    }

    public boolean isValidPair(Content content, Crew... crews) {
        for (Content cont : matching.keySet()) {
            if (!(cont.getCourse().equals(content.getCourse()) && cont.getLevel().equals(content.getLevel()))) {
                continue;
            }

            if (isAlreadyMatched(crews, cont)) {
                return false;
            }
        }
        return true;
    }

    private boolean isAlreadyMatched(Crew[] crews, Content cont) {
        List<Pair> pairs = matching.get(cont);
        for (Pair pair : pairs) {
            if (pair.contains(crews)) {
                return true;
            }
        }
        return false;
    }

    public void addPairs(List<Pair> pairs, Content content) {
        matching.put(content, pairs);
    }

    public List<Pair> getMatching(Content content) {
        return matching.get(content);
    }
}
