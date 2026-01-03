package pairmatching.command.impl;

import pairmatching.command.Command;
import pairmatching.constant.Content;
import pairmatching.constant.ErrorMessage;
import pairmatching.service.MatchingService;
import pairmatching.util.InputParser;
import pairmatching.util.Retry;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class QueryCommand implements Command {

    private final MatchingService service;

    public QueryCommand(MatchingService service) {
        this.service = service;
    }

    @Override
    public void execute() {
        Content content;
        while (true) {
            content = Retry.retryUntilSuccess(() -> InputParser.parseContent(InputView.readContent()));

            if (service.isAlreadyMatched(content)) {
                break;
            }

            OutputView.printErrorMessage(new IllegalArgumentException(ErrorMessage.MATCHING_FAIL.getErrorMessage()));
        }

        OutputView.printMatchingResult(service.getMatching(content));
    }
}
