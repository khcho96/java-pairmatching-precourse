package pairmatching.command.impl;

import pairmatching.command.Command;
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
        Content content = Retry.retryUntilSuccess(() -> InputParser.parseContent(InputView.readContent()));


        OutputView.printMatchingResult();
    }
}
