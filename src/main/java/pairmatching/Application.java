package pairmatching;

import java.io.IOException;
import pairmatching.command.MenuCommandRegistry;
import pairmatching.controller.MatchingController;
import pairmatching.service.MatchingService;

public class Application {
    public static void main(String[] args) {
        MatchingService service = new MatchingService();
        MenuCommandRegistry registry = MenuCommandRegistry.from(service);
        MatchingController controller = new MatchingController(registry, service);
        try {
            controller.run();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
