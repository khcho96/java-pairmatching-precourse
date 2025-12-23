package pairmatching.util;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class InputParser {

    private static final String DELIMITER = ",";
    private static final String FIRST_DELIMITER = ",";
    private static final String SECOND_DELIMITER = "-";

    private InputParser() {
    }

    public static List<String> parseContents(String readContents) {
        readContents = readContents.trim();

        Validator.validateCsvFormat(readContents);

        return Stream.of(readContents.split(DELIMITER))
                .map(String::trim)
                .collect(Collectors.toList());
    }
}
