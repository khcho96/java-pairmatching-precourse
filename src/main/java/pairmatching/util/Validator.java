package pairmatching.util;

import pairmatching.constant.ErrorMessage;

public final class Validator {

    private static final String CSV_FORMAT = "^[가-힣]+ *, *[가-힣\\d]+ *, *[가-힣]+ *$";

    private Validator() {}

    public static void validateCsvFormat(String input) {
        if (!input.matches(CSV_FORMAT)) {
            throw new IllegalArgumentException(ErrorMessage.FORMAT_ERROR.getErrorMessage());
        }
    }
}
