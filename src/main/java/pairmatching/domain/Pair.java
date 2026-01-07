package pairmatching.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Pair {

    private final List<Crew> pair;

    public Pair(Crew... crews) {
        this.pair = new ArrayList<>(Arrays.asList(crews));
    }

    public boolean contains(Crew... findCrews) {
        List<Crew> crews = Arrays.asList(findCrews);
        if (crews.size() == 2) {
            return new HashSet<>(pair).containsAll(crews);
        }

        return pairContains(crews);
    }

    private boolean pairContains(List<Crew> crews) {
        Crew crew1 = crews.get(0);
        Crew crew2 = crews.get(1);
        Crew crew3 = crews.get(2);
        if (new HashSet<>(pair).contains(crew1) && new HashSet<>(pair).contains(crew2)) {
            return true;
        }

        if (new HashSet<>(pair).contains(crew1) && new HashSet<>(pair).contains(crew3)) {
            return true;
        }

        if (new HashSet<>(pair).contains(crew2) && new HashSet<>(pair).contains(crew3)) {
            return true;
        }

        return false;
    }

    @Override
    public String toString() {
        return pair.stream()
                .map(Crew::getName)
                .collect(Collectors.joining(" : "));
    }
}
