package pairmatching.command;

import java.util.EnumMap;
import pairmatching.command.impl.MatchingCommand;
import pairmatching.command.impl.QueryCommand;
import pairmatching.service.MatchingService;

public class MenuCommandRegistry {

    private final EnumMap<MenuOption, Command> commands;

    private MenuCommandRegistry(EnumMap<MenuOption, Command> commands) {
        this.commands = commands;
    }

    public static MenuCommandRegistry from(MatchingService service) {
        EnumMap<MenuOption, Command> map = new EnumMap<>(MenuOption.class);
        map.put(MenuOption.A, new MatchingCommand(service));
        map.put(MenuOption.B, new QueryCommand(service));
        map.put(MenuOption.C, new ResetCommand(service));
        return new MenuCommandRegistry(map);
    }

    public void execute(MenuOption option) {
        commands.get(option).execute();
    }
}
