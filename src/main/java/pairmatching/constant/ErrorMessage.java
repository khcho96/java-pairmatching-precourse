package pairmatching.constant;

public enum ErrorMessage {

    INVALID_COURSE_ERROR("올바르지 않은 과정입니다."),
    CSV_FORMAT_ERROR("쉼표(,)를 기준으로 구분되는 입력이어야 합니다."),
    _ERROR("%d 이상 %d 이하의 숫자만 가능합니다.."),
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
