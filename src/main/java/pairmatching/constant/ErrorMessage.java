package pairmatching.constant;

public enum ErrorMessage {

    FORMAT_ERROR("잘못된 형식입니다."),

    COURSE_ERROR("잘못된 과정입니다."),
    LEVEL_ERROR("잘못된 레벨입니다."),
    MISSION_ERROR("잘못된 미션입니다."),
    ;

    private static final String ERROR_MESSAGE_PREFIX = "[ERROR] ";
    private final String errorMessage;

    ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage(Object... args) {
        return ERROR_MESSAGE_PREFIX + String.format(errorMessage, args);
    }
}
