package pairmatching.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import pairmatching.constant.Course;

class CrewTest {

    @Test
    void 크루_생성() {
        Crew crew = Crew.from("제이콥", Course.BACKEND);
        assertThat(crew).isEqualTo(Crew.from("제이콥", Course.BACKEND));
    }
}