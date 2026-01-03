package pairmatching.command.impl;

import pairmatching.command.Command;
import pairmatching.command.RematchOption;
import pairmatching.constant.Content;
import pairmatching.service.MatchingService;
import pairmatching.util.InputParser;
import pairmatching.util.Retry;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class MatchingCommand implements Command {

    private final MatchingService service;

    public MatchingCommand(MatchingService service) {
        this.service = service;
    }

    @Override
    public void execute() {
        while (true) {
            Content content = Retry.retryUntilSuccess(() -> InputParser.parseContent(InputView.readContent()));

            if (service.isAlreadyMatched(content)) {
                RematchOption rematchOption = Retry.retryUntilSuccess(() -> InputParser.parseRematch(InputView.readRematch()));

                if (rematchOption.equals(RematchOption.NO)) {
                    continue;
                }
            }

            service.generateMaching();
        }

        OutputView.printMatchingResult();
    }
}
