package pairmatching.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
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

    public void add(Content content, List<Pair> newPairs) {
        matching.put(content, new ArrayList<>(newPairs));
    }

    public boolean pairAlreadyExists(Content keyContent, Pair newPair) {
        List<Content> sameLevelMatching = Arrays.stream(Content.values())
                .filter(content -> content.getLevel().equals(keyContent.getLevel()))
                .filter(content -> !content.equals(keyContent))
                .collect(Collectors.toList());

        for (Content content : sameLevelMatching) {
            List<Pair> pairs = matching.get(content);

            return pairs.stream()
                    .anyMatch(pair -> pair.contains(newPair));
        }

        return false;
    }

    public List<Pair> getMatching(Content content) {
        return matching.get(content);
    }

    public void reset() {
        for (Content content : matching.keySet()) {
            matching.get(content).clear();
        }
    }
}
