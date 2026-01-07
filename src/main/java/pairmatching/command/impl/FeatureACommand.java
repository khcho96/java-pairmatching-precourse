package pairmatching.command.impl;

import pairmatching.command.Command;
import pairmatching.constant.Content;
import pairmatching.constant.ErrorMessage;
import pairmatching.constant.RematchOption;
import pairmatching.service.MatchingService;
import pairmatching.util.InputParser;
import pairmatching.util.Retry;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class FeatureACommand implements Command {

    private final MatchingService service;

    public FeatureACommand(MatchingService service) {
        this.service = service;
    }

    @Override
    public void execute() {
        Content content;
        while (true) {
            content = getContent();

            if (readOptionIfMatchingExists(content)) {
                continue;
            }

            if (service.tryMatching(content)) {
                break;
            }

            OutputView.printErrorMessage(new IllegalArgumentException(ErrorMessage.MATCHING_FAILURE_ERROR.getErrorMessage()));
        }

        OutputView.printMatching(service.getMatching(content));
    }

    private boolean readOptionIfMatchingExists(Content content) {
        if (service.MatchingExists(content)) {
            RematchOption rematchOption = Retry.retryUntilSuccess(() ->
                    InputParser.parseRematch(InputView.readRematch())
            );

            if (rematchOption.equals(RematchOption.NO)) {
                return true;
            }
        }
        return false;
    }

    private static Content getContent() {
        Content content;
        content = Retry.retryUntilSuccess(() ->
                InputParser.parseContent(InputView.readContent())
        );
        return content;
    }
}
