package pairmatching.view;

import java.util.List;
import pairmatching.domain.Pair;

public class OutputView {

    private OutputView() {
    }

    public static void printErrorMessage(IllegalArgumentException e) {
        System.out.println(e.getMessage());
    }

    public static void printMatching(List<Pair> matching) {
        System.out.println("\n페어 매칭 결과입니다.");
        for (Pair pair : matching) {
            System.out.println(pair);
        }
    }
}
