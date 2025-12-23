package pairmatching.controller;

import java.io.IOException;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Supplier;
import pairmatching.constant.Command;
import pairmatching.constant.Course;
import pairmatching.constant.Level;
import pairmatching.constant.Mission;
import pairmatching.domain.Crew;
import pairmatching.service.PairMatchingService;
import pairmatching.util.InputParser;
import pairmatching.util.Validator;
import pairmatching.util.file.FileReader;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class Controller {

    private final PairMatchingService pairMatchingService;

    public Controller(PairMatchingService service) {
        this.pairMatchingService = service;
    }

    public void run() throws IOException {
        registerFiles();

        retryOnError(() -> {

            while (true) {
                String commandName = InputView.readCommand();
                Command command = Command.fromCommand(commandName);

                if (command.equals(Command.MATCHING)) {
                    while (true) {
                        String readContents = InputView.readContents();
                        List<String> contents = InputParser.parseContents(readContents);

                        if (pairMatchingService.isMatched(contents)) {
                            String reMatching = retryOnError(() -> {
                                String readReMatching = InputView.readReMatching();
                                Validator.validateReMatchCommandFormat(readReMatching);
                                return readReMatching;
                            });

                            if (reMatching.equals("네")) {
                                pairMatchingService.delete(contents);
                            }

                            if (reMatching.equals("아니오")) {
                                continue;
                            }
                        }

                        EnumMap<Course, EnumMap<Level, Map<Mission, List<Set<Crew>>>>> matching =
                                pairMatchingService.makeMatching(contents);
                        OutputView.printMatching(matching, contents);
                        break;
                    }
                }

                if (command.equals(Command.VIEW)) {
                    return;
                }

                if (command.equals(Command.RESET)) {
                    return;
                }

                if (command.equals(Command.QUIT)) {
                    break;
                }
            }
        });
    }

    private void registerFiles() throws IOException {
        FileReader fileReader = new FileReader("src/main/resources/backend-crew.md");
        List<String> backendCrews = fileReader.readLines();
        fileReader = new FileReader("src/main/resources/frontend-crew.md");
        List<String> frontendCrews = fileReader.readLines();

        pairMatchingService.setCrews(backendCrews, frontendCrews);
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
