package pairmatching.util;

import pairmatching.constant.ErrorMessage;

public final class Validator {

    private static final String CONTENT_FORMAT = "^[가-힣]+ *, *[가-힣\\d]+ *, *[가-힣]+$";

    private Validator() {}

    public static void validateContentFormat(String input) {
        if (!input.matches(CONTENT_FORMAT)) {
            throw new IllegalArgumentException(ErrorMessage.FORMAT_ERROR.getErrorMessage());
        }
    }
}
