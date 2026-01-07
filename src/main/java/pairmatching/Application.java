package pairmatching;

import java.io.IOException;
import pairmatching.command.MenuCommandRegistry;
import pairmatching.controller.MatchingController;
import pairmatching.service.MatchingService;

public class Application {
    public static void main(String[] args) {
        MatchingService matchingService = new MatchingService();
        MenuCommandRegistry registry = MenuCommandRegistry.from(matchingService);
        MatchingController matchingController = new MatchingController(registry, matchingService);
        try {
            matchingController.run();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
