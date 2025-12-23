package pairmatching;

import java.io.IOException;
import java.util.List;
import java.util.function.Supplier;
import pairmatching.constant.Course;
import pairmatching.domain.Crews;
import pairmatching.util.file.FileReader;
import pairmatching.view.OutputView;

public class Application {

    private static Crews crews;

    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader("resources/backend-crew.md");
        List<String> backendCrews = fileReader.readLines();
        fileReader = new FileReader("resources/frontend-crew.md");
        List<String> frontendCrews = fileReader.readLines();

        crews = Crews.newInstance();
        for (String backendCrew : backendCrews) {
            crews.addCrew(backendCrew, Course.BACKEND);
        }
        for (String frontendCrew : frontendCrews) {
            crews.addCrew(frontendCrew, Course.FRONTEND);
        }

    }

    private <T> T retryOnError(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e);
            }
        }
    }

    private void retryOnError(Runnable runnable) {
        while (true) {
            try {
                runnable.run();
                return;
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e);
            }
        }
    }
}
