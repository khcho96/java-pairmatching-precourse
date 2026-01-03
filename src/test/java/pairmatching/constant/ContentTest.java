package pairmatching.constant;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class ContentTest {

    @Test
    void 과정레벨미션_반환_정상() {
        Content content = Content.of(Course.BACKEND, Level.LEVEL1, Mission.RACING_CAR);
        assertThat(content).isEqualTo(Content.CONTENT1);
    }
}