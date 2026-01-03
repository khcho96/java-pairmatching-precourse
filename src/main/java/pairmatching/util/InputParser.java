package pairmatching.util;

import pairmatching.command.MenuOption;
import pairmatching.command.RematchOption;
import pairmatching.constant.Content;
import pairmatching.constant.Course;
import pairmatching.constant.Level;
import pairmatching.constant.Mission;

public final class InputParser {

    private static final String DELIMITER = ",";

    private InputParser() {
    }

    public static Content parseContent(String rawInput) {
        rawInput = rawInput.trim();

        Validator.validateCsvFormat(rawInput);

        String[] split = rawInput.split(DELIMITER);
        Course course = Course.fromName(split[0].trim());
        Level level = Level.fromName(split[1].trim());
        Mission mission = Mission.of(split[2].trim(), level);

        return Content.of(course, level, mission);
    }

    public static MenuOption parseMenu(String rawInput) {
        return MenuOption.from(rawInput.trim());
    }

    public static RematchOption parseRematch(String rawInput) {
        return RematchOption.from(rawInput.trim());
    }
}
