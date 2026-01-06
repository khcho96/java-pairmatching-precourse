package pairmatching.command;

import java.util.Arrays;
import pairmatching.constant.ErrorMessage;

public enum RematchOption {

    YES("네"),
    NO("아니오"),
    ;

    private final String command;

    RematchOption(String command) {
        this.command = command;
    }

    public static RematchOption from(String command) {
        String normalized = command.trim();
        return Arrays.stream(values())
                .filter(opt -> opt.command.equals(normalized))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.FORMAT_ERROR.getErrorMessage()));
    }
}
