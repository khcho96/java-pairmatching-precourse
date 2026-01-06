package pairmatching.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import pairmatching.constant.Course;

class CrewsTest {

    @Test
    void 크루_생성_및_과정별_크루_반환() {
        Crews crews = Crews.newInstance();

        crews.registerCrews(Arrays.asList("가", "나", "다", "라", "마"), Course.BACKEND);
        crews.registerCrews(Arrays.asList("바", "사", "아", "자", "차"), Course.FRONTEND);

        List<String> backendCrews = crews.getCrewNames(Course.BACKEND);
        List<String> frontendCrews = crews.getCrewNames(Course.FRONTEND);

        assertThat(backendCrews).containsExactly("가", "나", "다", "라", "마");
        assertThat(frontendCrews).containsExactly("바", "사", "아", "자", "차");
    }

    @Test
    void 크루_생성_및_이름으로_크루_반환() {
        Crews crews = Crews.newInstance();

        crews.registerCrews(Arrays.asList("가", "나", "다", "라", "마"), Course.BACKEND);
        crews.registerCrews(Arrays.asList("바", "사", "아", "자", "차"), Course.FRONTEND);

        Crew crew = crews.getCrew("가");

        assertThat(crew).isEqualTo(Crew.from("가", Course.BACKEND));
    }
}