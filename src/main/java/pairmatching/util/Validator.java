package pairmatching.util;

import pairmatching.constant.ErrorMessage;

public final class Validator {

    private static final String CSV_FORMAT = "^ *( *\\S+ *, *\\S+ *, *\\S+ *) *$";

    private Validator() {}

    public static void validateCsvFormat(String readContents) {
        if (!readContents.matches(CSV_FORMAT)) {
            throw new IllegalArgumentException(ErrorMessage.FORMAT_ERROR.getErrorMessage());
        }
    }

    public static void validateReMatchCommandFormat(String reMatching) {
        if (!reMatching.trim().matches("네|아니오")) {
            throw new IllegalArgumentException(ErrorMessage.REMATCH_FORMAT_ERROR.getErrorMessage());
        }
    }

//    public static void validateNumberFormat(String input) {
//        if (!input.matches(NUMBER_FORMAT)) {
//            throw new IllegalArgumentException(NUMBER_FORMAT_ERROR.getErrorMessage());
//        }
//    }
//
//    public static void validateCsvFormat(String input) {
//        if (!input.matches(CSV_FORMAT)) {
//            throw new IllegalArgumentException(CSV_FORMAT_ERROR.getErrorMessage());
//        }
//    }
}
