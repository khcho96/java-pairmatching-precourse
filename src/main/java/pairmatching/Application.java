package pairmatching;

import java.io.IOException;
import pairmatching.controller.Controller;
import pairmatching.domain.Crews;
import pairmatching.service.PairMatchingService;

public class Application {

    private static Crews crews;

    public static void main(String[] args) throws IOException {
        PairMatchingService pairMatchingService = new PairMatchingService();
        Controller controller = new Controller(pairMatchingService);
        controller.run();
    }
}
