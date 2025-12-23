package pairmatching.constant;

public enum ErrorMessage {

    INVALID_COMMAND_ERROR("\"1\", \"2\", \"3\", \"Q\" 중 하나를 입력해야 합니다."),

    FORMAT_ERROR("올바르지 않은 형식의 입력입니다."),
    INVALID_COURSE_ERROR("올바르지 않은 과정입니다."),
    INVALID_LEVEL_ERROR("올바르지 않은 레벨입니다."),
    EMPTY_MISSION_ERROR("미션이 존재하지 않는 레벨입니다"),
    INVALID_MISSION_ERROR("올바르지 않은 미션입니다."),

    REMATCH_FORMAT_ERROR("\"네\", \"아니오\" 중 하나를 입력해야 합니다.");

    private static final String ERROR_MESSAGE_PREFIX = "[ERROR] ";
    private final String errorMessage;

    ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage(Object... args) {
        return ERROR_MESSAGE_PREFIX + String.format(errorMessage, args);
    }
}
