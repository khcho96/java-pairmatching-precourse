package pairmatching.constant;

import java.util.Arrays;

public enum RematchOption {

    YES("네"),
    NO("아니오"),
    ;

    private final String command;

    RematchOption(String command) {
        this.command = command;
    }

    public static RematchOption from(String command) {
        return Arrays.stream(values())
                .filter(opt -> opt.command.equals(command))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.FORMAT_ERROR.getErrorMessage()));
    }
}
