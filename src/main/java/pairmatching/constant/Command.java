package pairmatching.constant;

import java.util.Arrays;

public enum Command {
    MATCHING("1"),
    VIEW("2"),
    RESET("3"),
    QUIT("Q"),
    ;

    private final String command;

    Command(String command) {
        this.command = command;
    }

    public static Command fromCommand(String command) {
        return Arrays.stream(values())
                .filter(constant -> constant.command.equals(command))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.INVALID_COMMAND_ERROR.getErrorMessage()));
    }
}
