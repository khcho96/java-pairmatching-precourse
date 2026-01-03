package pairmatching.controller;

import java.io.IOException;
import java.util.List;
import pairmatching.command.MenuCommandRegistry;
import pairmatching.command.MenuOption;
import pairmatching.constant.Course;
import pairmatching.service.MatchingService;
import pairmatching.util.InputParser;
import pairmatching.util.Retry;
import pairmatching.util.file.FileReader;
import pairmatching.view.InputView;

public class MatchingController {

    private final MenuCommandRegistry registry;
    private final MatchingService service;

    public MatchingController(MenuCommandRegistry registry, MatchingService service) {
        this.registry = registry;
        this.service = service;
    }

    public void run() throws IOException {
        registerFileInfo();

        while (true) {
            MenuOption option = readOption();

            if (option.equals(MenuOption.QUIT)) {
                return;
            }

            registry.execute(option);
        }
    }

    private void registerFileInfo() throws IOException {
        FileReader fileReader = new FileReader("src/main/resources/backend-crew.md");
        List<String> readLines = fileReader.readLines();
        service.registerFileInfo(readLines, Course.BACKEND);

        fileReader = new FileReader("src/main/resources/backend-crew.md");
        readLines = fileReader.readLines();
        service.registerFileInfo(readLines, Course.FRONTEND);
    }

    private MenuOption readOption() {
        return Retry.retryUntilSuccess(() -> InputParser.parseMenu(InputView.readMainMenuSelection()));
    }
}
