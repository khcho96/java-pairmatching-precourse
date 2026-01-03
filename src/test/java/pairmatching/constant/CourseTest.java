package pairmatching.constant;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CourseTest {

    @Test
    void 과정_반환_정상() {
        Course course = Course.fromName("백엔드");
        assertThat(course).isEqualTo(Course.BACKEND);
    }

    @Test
    void 과정_반환_오류() {
        assertThatThrownBy(() -> Course.fromName("엔드"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.COURSE_ERROR.getErrorMessage());
    }
}