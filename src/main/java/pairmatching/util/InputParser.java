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
        rawInput = rawInput.trim();

        Validator.validateContentFormat(rawInput);

        String[] content = rawInput.split(DELIMITER);
        Course course = Course.from(content[0].trim());
        Level level = Level.from(content[1].trim());
        Mission mission = Mission.from(content[2].trim(), level);

        return Content.from(course, level, mission);
    }

    public static MenuOption parseMenu(String rawInput) {
        return MenuOption.from(rawInput.trim());
    }
}
