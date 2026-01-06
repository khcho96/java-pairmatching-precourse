package pairmatching.util;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import pairmatching.command.MenuOption;
import pairmatching.command.RematchOption;
import pairmatching.constant.Content;

class InputParserTest {

    @Test
    void 기능_입력_파싱() {
        assertThat(InputParser.parseMenu("2")).isEqualTo(MenuOption.B);
    }

    @Test
    void 과정레벨미션_입력_파싱() {
        assertThat(InputParser.parseContent(" 백엔드,  레벨1 , 자동차경주  ")).isEqualTo(Content.BACKEND_LEVEL1_RACING_CAR);
    }

    @Test
    void 재미칭여부_입력_파싱() {
        assertThat(InputParser.parseRematch("아니오")).isEqualTo(RematchOption.NO);
    }
}