package pairmatching.util;

import pairmatching.command.MenuOption;
import pairmatching.constant.Content;
import pairmatching.constant.Course;
import pairmatching.constant.Level;
import pairmatching.constant.Mission;

public final class InputParser {

    private static final String DELIMITER = ",";

    private InputParser() {
    }

    public static Content parseContent(String rawInput) {
        rawInput = rawInput.strip();

        Validator.validateCsvFormat(rawInput);

        String[] split = rawInput.split(DELIMITER);

        Course course = Course.fromName(split[0].strip());
        Level level = Level.fromName(split[1].strip());
        Mission mission = Mission.of(split[2].strip(), level);

        return Content.fromName(course, level, mission);
    }

    public static MenuOption parseMenu(String rawInput) {
        return MenuOption.from(rawInput.strip());
    }
}
