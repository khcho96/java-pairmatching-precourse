package pairmatching.constant;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MissionTest {

    @Test
    void 미션_반환_정상() {
        Mission mission = Mission.of("자동차경주", Level.LEVEL1);
        assertThat(mission).isEqualTo(Mission.RACING_CAR);
    }

    @Test
    void 미션_반환_이름_오류() {
        assertThatThrownBy(() -> Mission.of("축구", Level.LEVEL1))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(ErrorMessage.MISSION_ERROR.getErrorMessage());
    }

    @Test
    void 미션_반환_레벨_오류() {
        assertThatThrownBy(() -> Mission.of("자동차경주", Level.LEVEL2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.MISSION_ERROR.getErrorMessage());
    }
}