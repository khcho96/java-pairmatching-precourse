package pairmatching.view;

import java.util.List;
import pairmatching.domain.Pair;

public class OutputView {

    private OutputView() {
    }

    public static void printErrorMessage(IllegalArgumentException e) {
        System.out.println(e.getMessage());
    }

    public static void printMatchingResult(List<Pair> matching) {
        System.out.println("\n페어 매칭 결과입니다.");

        for (Pair pair : matching) {
            System.out.println(String.join(" : ", pair.getCrews()));
        }

        System.out.println();
    }

    public static void printReset() {
        System.out.println("\n초기화 되었습니다.");
    }
}
