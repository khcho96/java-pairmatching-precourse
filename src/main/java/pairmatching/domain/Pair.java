package pairmatching.domain;

import java.util.ArrayList;
import java.util.List;

public class Pair {

    private final List<Crew> pair;

    private Pair(List<Crew> pair) {
        this.pair = pair;
    }

    public static Pair of(Crew... crews) {
        return new Pair(new ArrayList<>(List.of(crews)));
    }

    public boolean contains(Pair newPair) {
        List<List<Crew>> doublePairs = newPair.getDoublePairs();

        return doublePairs.stream()
                .anyMatch(pair::containsAll);
    }

    private List<List<Crew>> getDoublePairs() {
        List<List<Crew>> doublePairs = new ArrayList<>();

        if (pair.size() == 2) {
            doublePairs.add(pair);
            return doublePairs;
        }

        doublePairs.add(List.of(pair.get(0), pair.get(1)));
        doublePairs.add(List.of(pair.get(0), pair.get(2)));
        doublePairs.add(List.of(pair.get(1), pair.get(2)));

        return doublePairs;
    }

    public List<String> getCrews() {
        return pair.stream()
                .map(Crew::getName)
                .toList();
    }
}
