package pairmatching.command.impl;

import pairmatching.command.Command;
import pairmatching.command.RematchOption;
import pairmatching.constant.Content;
import pairmatching.constant.ErrorMessage;
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
        Content content;
        while (true) {
            content = Retry.retryUntilSuccess(() -> InputParser.parseContent(InputView.readContent()));

            if (readRematchIfAlreadyMatched(content)) {
                continue;
            }

            if (service.generateMatching(content)) {
                break;
            }
            OutputView.printErrorMessage(new IllegalArgumentException(ErrorMessage.MATCHING_FAIL.getErrorMessage()));
        }

        OutputView.printMatchingResult(service.getMatching(content));
    }

    private boolean readRematchIfAlreadyMatched(Content content) {
        if (service.isAlreadyMatched(content)) {
            RematchOption rematchOption = Retry.retryUntilSuccess(() -> InputParser.parseRematch(InputView.readRematch()));

            return rematchOption.equals(RematchOption.NO);
        }
        return false;
    }
}
