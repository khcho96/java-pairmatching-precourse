package pairmatching.command;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import pairmatching.constant.ErrorMessage;

class RematchOptionTest {

    @Test
    void 기능_반환_정상() {
        assertThat(RematchOption.from("네")).isEqualTo(RematchOption.YES);
    }

    @Test
    void 기능_반환_오류() {
        assertThatThrownBy(() -> RematchOption.from("예"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.FORMAT_ERROR.getErrorMessage());
    }
}