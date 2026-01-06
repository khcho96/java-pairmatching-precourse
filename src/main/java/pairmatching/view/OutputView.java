package pairmatching.view;

public class OutputView {

    private OutputView() {
    }

    public static void printErrorMessage(IllegalArgumentException e) {
        System.out.println(e.getMessage());
    }

    public static void print() {
    }
}
