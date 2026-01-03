package pairmatching.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import pairmatching.constant.Content;

public class Matching {

    private final Map<Content, List<Pair>> matching;

    private Matching(Map<Content, List<Pair>> matching) {
        this.matching = matching;
    }

    public static Matching newInstance() {
        Map<Content, List<Pair>> matching = new HashMap<>();
        for (Content content : Content.values()) {
            matching.put(content, new ArrayList<>());
        }
        return new Matching(matching);
    }

    public boolean isAlreadyMatched(Content content) {
        return !matching.get(content).isEmpty();
    }
}
