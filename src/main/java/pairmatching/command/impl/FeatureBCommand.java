package pairmatching.command.impl;

import pairmatching.command.Command;
import pairmatching.service.MatchingService;

public class FeatureBCommand implements Command {

    private final MatchingService service;

    public FeatureBCommand(MatchingService service) {
        this.service = service;
    }

    @Override
    public void execute() {

    }
}
