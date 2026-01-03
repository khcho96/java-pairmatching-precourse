package pairmatching.service;

import static camp.nextstep.edu.missionutils.test.Assertions.assertShuffleTest;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import pairmatching.constant.Content;
import pairmatching.constant.Course;

class MatchingServiceTest {

    private final MatchingService matchingService = new MatchingService();

    @Test
    void 페어_매칭_여부_반환() {
        matchingService.registerFileInfo(
                new ArrayList<>(Arrays.asList("치수", "백호", "태웅", "태섭", "호열", "대남", "용팔", "구식", "달재")),
                Course.BACKEND
        );
        matchingService.generateMatching(Content.CONTENT1);

        boolean alreadyMatched = matchingService.isAlreadyMatched(Content.CONTENT1);
        assertThat(alreadyMatched).isTrue();
    }

    @Test
    void 페어_매칭_성공_테스트() {
        assertShuffleTest(
                () -> {
                    matchingService.registerFileInfo(
                            new ArrayList<>(Arrays.asList("치수", "백호", "태웅", "태섭", "호열", "대남", "용팔", "구식", "달재")),
                            Course.BACKEND
                    );
                    boolean isSuccess = matchingService.generateMatching(Content.CONTENT1);
                    assertThat(isSuccess).isTrue();
                },
                Arrays.asList("태웅", "달재", "백호", "호열", "대남", "용팔", "태섭", "치수", "구식"),
                Arrays.asList("태웅", "백호", "치수", "태섭", "호열", "대남", "용팔", "구식", "달재")
        );
    }

    @Test
    void 페어_매칭_실패_테스트() {
        assertShuffleTest(
                () -> {
                    matchingService.registerFileInfo(
                            new ArrayList<>(Arrays.asList("치수", "백호", "태웅", "태섭", "호열", "대남", "용팔", "구식", "달재")),
                            Course.BACKEND
                    );
                    matchingService.generateMatching(Content.CONTENT1); // 첫 매칭
                    boolean isSuccess = matchingService.generateMatching(Content.CONTENT1); // 재매칭
                    assertThat(isSuccess).isFalse();
                },
                Arrays.asList("태웅", "달재", "백호", "호열", "대남", "치수", "태섭", "용팔", "구식"),
                Arrays.asList("태웅", "백호", "치수", "태섭", "호열", "대남", "용팔", "구식", "달재") // 용팔,구식 또 매칭
        );
    }

    @Test
    void 페어_매칭_기록_초기화_확인() {
        matchingService.registerFileInfo(
                new ArrayList<>(Arrays.asList("치수", "백호", "태웅", "태섭", "호열", "대남", "용팔", "구식", "달재")),
                Course.BACKEND
        );
        matchingService.generateMatching(Content.CONTENT1);

        matchingService.reset();

        boolean alreadyMatched = matchingService.isAlreadyMatched(Content.CONTENT1);
        assertThat(alreadyMatched).isFalse();
    }
}