package pairmatching.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;
import pairmatching.constant.Course;

class PairTest {

    @Test
    void 페어_매칭_여부_확인_매칭() {
        Crew firstCrew = Crew.from("가", Course.BACKEND);
        Crew secondCrew = Crew.from("나", Course.BACKEND);
        Pair pair = Pair.of(firstCrew, secondCrew);

        Crew thirdCrew = Crew.from("가", Course.BACKEND);
        Crew fourthCrew = Crew.from("나", Course.BACKEND);
        Crew fifthCrew = Crew.from("마", Course.BACKEND);
        Pair newPair = Pair.of(thirdCrew, fourthCrew, fifthCrew);

        assertThat(pair.contains(newPair)).isTrue();
    }

    @Test
    void 페어_매칭_여부_확인_비매칭() {
        Crew firstCrew = Crew.from("가", Course.BACKEND);
        Crew secondCrew = Crew.from("나", Course.BACKEND);
        Pair pair = Pair.of(firstCrew, secondCrew);

        Crew thirdCrew = Crew.from("다", Course.BACKEND);
        Crew fourthCrew = Crew.from("라", Course.BACKEND);
        Crew fifthCrew = Crew.from("마", Course.BACKEND);
        Pair newPair = Pair.of(thirdCrew, fourthCrew, fifthCrew);

        assertThat(pair.contains(newPair)).isFalse();
    }

    @Test
    void 크루_리스트_반환() {
        Crew firstCrew = Crew.from("가", Course.BACKEND);
        Crew secondCrew = Crew.from("나", Course.BACKEND);
        Crew thirdCrew = Crew.from("다", Course.BACKEND);
        Pair pair = Pair.of(firstCrew, secondCrew, thirdCrew);

        List<String> crews = pair.getCrews();
        assertThat(crews).containsExactly("가", "나", "다");
    }
}