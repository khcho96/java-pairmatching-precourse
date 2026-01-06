package pairmatching.command;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import pairmatching.constant.ErrorMessage;

class MenuOptionTest {

    @Test
    void 기능_반환_정상() {
        assertThat(MenuOption.from("1")).isEqualTo(MenuOption.A);
    }

    @Test
    void 기능_반환_오류() {
        assertThatThrownBy(() -> MenuOption.from("4"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.FORMAT_ERROR.getErrorMessage());
    }
}