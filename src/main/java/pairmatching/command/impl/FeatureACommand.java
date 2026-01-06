package pairmatching.command.impl;

import pairmatching.command.Command;
import pairmatching.service.MatchingService;

public class FeatureACommand implements Command {

    private final MatchingService service;

    public FeatureACommand(MatchingService service) {
        this.service = service;
    }

    @Override
    public void execute() {

    }
}
