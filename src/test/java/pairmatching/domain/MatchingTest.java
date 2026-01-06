package pairmatching.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import pairmatching.constant.Content;
import pairmatching.constant.Course;

class MatchingTest {

    @Test
    void 매칭_여부_확인_비매칭() {
        Matching matching = Matching.newInstance();

        assertThat(matching.isAlreadyMatched(Content.BACKEND_LEVEL1_RACING_CAR))
                .isFalse();
    }

    @Test
    void 매칭_여부_확인_매칭() {
        Matching matching = Matching.newInstance();
        Crew firstCrew = Crew.from("가", Course.BACKEND);
        Crew secondCrew = Crew.from("나", Course.BACKEND);

        matching.add(Content.BACKEND_LEVEL1_RACING_CAR, Arrays.asList(Pair.of(firstCrew, secondCrew)));

        assertThat(matching.isAlreadyMatched(Content.BACKEND_LEVEL1_RACING_CAR))
                .isTrue();
    }

    @Test
    void 매칭_실행_및_같은_레벨_미션_이전_매칭_여부_확인_비매칭() {
        Matching matching = Matching.newInstance();
        Crew firstCrew = Crew.from("가", Course.BACKEND);
        Crew secondCrew = Crew.from("나", Course.BACKEND);
        List<Pair> oldPairs = Arrays.asList(Pair.of(firstCrew, secondCrew));

        matching.add(Content.BACKEND_LEVEL1_RACING_CAR, oldPairs);

        Crew thirdCrew = Crew.from("다", Course.BACKEND);
        Crew fourthCrew = Crew.from("라", Course.BACKEND);
        Pair newPair = Pair.of(thirdCrew, fourthCrew);

        assertThat(matching.pairAlreadyExists(Content.BACKEND_LEVEL1_LOTTO, newPair))
                .isFalse();
    }

    @Test
    void 매칭_실행_및_같은_레벨_미션_이전_매칭_여부_확인_매칭() {
        Matching matching = Matching.newInstance();
        Crew firstCrew = Crew.from("가", Course.BACKEND);
        Crew secondCrew = Crew.from("나", Course.BACKEND);
        List<Pair> oldPairs = Arrays.asList(Pair.of(firstCrew, secondCrew));

        matching.add(Content.BACKEND_LEVEL1_RACING_CAR, oldPairs);

        Crew thirdCrew = Crew.from("가", Course.BACKEND);
        Crew fourthCrew = Crew.from("나", Course.BACKEND);
        Crew fifthCrew = Crew.from("다", Course.BACKEND);
        Pair newPair = Pair.of(thirdCrew, fourthCrew, fifthCrew);

        assertThat(matching.pairAlreadyExists(Content.BACKEND_LEVEL1_LOTTO, newPair))
                .isTrue();
    }

    @Test
    void 매칭_실행_및_결과_반환() {
        Matching matching = Matching.newInstance();
        Crew firstCrew = Crew.from("가", Course.BACKEND);
        Crew secondCrew = Crew.from("나", Course.BACKEND);
        List<Pair> pairs = Arrays.asList(Pair.of(firstCrew, secondCrew));

        matching.add(Content.BACKEND_LEVEL1_RACING_CAR, pairs);

        assertThat(matching.getMatching(Content.BACKEND_LEVEL1_RACING_CAR))
                .isNotEmpty();
    }

    @Test
    void 매칭_미실행_및_결과_반환() {
        Matching matching = Matching.newInstance();

        assertThat(matching.getMatching(Content.BACKEND_LEVEL1_RACING_CAR))
                .isEmpty();
    }

    @Test
    void 매칭_기록_초기화() {
        Matching matching = Matching.newInstance();
        Crew firstCrew = Crew.from("가", Course.BACKEND);
        Crew secondCrew = Crew.from("나", Course.BACKEND);
        List<Pair> pairs = Arrays.asList(Pair.of(firstCrew, secondCrew));

        matching.add(Content.BACKEND_LEVEL1_RACING_CAR, pairs);

        matching.reset();

        assertThat(matching.getMatching(Content.BACKEND_LEVEL1_RACING_CAR))
                .isEmpty();
    }
}