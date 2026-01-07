package pairmatching.command.impl;

import pairmatching.command.Command;
import pairmatching.service.MatchingService;
import pairmatching.view.OutputView;

public class FeatureCCommand implements Command {

    private final MatchingService service;

    public FeatureCCommand(MatchingService service) {
        this.service = service;
    }

    @Override
    public void execute() {
        service.reset();

        OutputView.printReset();
    }
}
