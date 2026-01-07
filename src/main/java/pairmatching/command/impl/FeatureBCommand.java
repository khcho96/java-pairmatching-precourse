package pairmatching.command.impl;

import pairmatching.command.Command;
import pairmatching.constant.Content;
import pairmatching.constant.ErrorMessage;
import pairmatching.service.MatchingService;
import pairmatching.util.InputParser;
import pairmatching.util.Retry;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class FeatureBCommand implements Command {

    private final MatchingService service;

    public FeatureBCommand(MatchingService service) {
        this.service = service;
    }

    @Override
    public void execute() {
        Content content;
        while (true) {
            content = getContent();

            if (service.MatchingExists(content)) {
                break;
            }

            OutputView.printErrorMessage(new IllegalArgumentException(ErrorMessage.NO_EXIST_MATCHING_ERROR.getErrorMessage()));
        }

        OutputView.printMatching(service.getMatching(content));
    }

    private static Content getContent() {
        Content content;
        content = Retry.retryUntilSuccess(() ->
                InputParser.parseContent(InputView.readContent())
        );
        return content;
    }
}
