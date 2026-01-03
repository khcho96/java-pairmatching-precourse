package pairmatching.constant;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LevelTest {

    @Test
    void 레벨_반환_정상() {
        Level level = Level.fromName("레벨1");
        assertThat(level).isEqualTo(Level.LEVEL1);
    }

    @Test
    void 레벨_반환_오류() {
        assertThatThrownBy(() -> Level.fromName("레벨6"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.LEVEL_ERROR.getErrorMessage());
    }
}