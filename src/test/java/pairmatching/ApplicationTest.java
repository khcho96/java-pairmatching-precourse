package pairmatching;

import static camp.nextstep.edu.missionutils.test.Assertions.assertShuffleTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import pairmatching.constant.ErrorMessage;

class ApplicationTest extends NsTest {

    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    void 짝수_인원_페어_매칭() {
        assertShuffleTest(
            () -> {
                run("1", "백엔드, 레벨1, 자동차경주", "Q");
                assertThat(output()).contains("태웅 : 백호", "치수 : 태섭");
            },
            Arrays.asList("태웅", "백호", "치수", "태섭")
        );
    }

    @Test
    void 없는_미션에_대한_예외_처리() {
        assertSimpleTest(
            () -> {
                runException("1", "백엔드, 레벨1, 오징어게임");
                assertThat(output()).contains(ERROR_MESSAGE);
            }
        );
    }

    @Test
    void 홀수_인원_페어_매칭() {
        assertShuffleTest(
                () -> {
                    run("1", "백엔드, 레벨1, 자동차경주", "Q");
                    assertThat(output()).contains("태웅 : 백호", "치수 : 태섭 : 소연");
                },
                Arrays.asList("태웅", "백호", "치수", "태섭", "소연")
        );
    }

    @Test
    void 재매칭() {
        assertShuffleTest(
                () -> {
                    run("1", "백엔드, 레벨1, 자동차경주", "1", "백엔드, 레벨1, 자동차경주", "네", "Q");
                    assertThat(output()).contains("태웅 : 백호", "치수 : 태섭 : 소연");
                    assertThat(output()).contains("치수 : 태섭", "태웅 : 백호 : 소연");
                },
                Arrays.asList("태웅", "백호", "치수", "태섭", "소연"),
                Arrays.asList("치수", "태섭", "태웅", "백호", "소연")
        );
    }

    @Test
    void 매칭_실패() {
        assertShuffleTest(
                () -> {
                    runException("1", "백엔드, 레벨1, 자동차경주", "1", "백엔드, 레벨1, 로또");
                },
                Arrays.asList("태웅", "백호", "치수", "태섭", "소연"),
                Arrays.asList("치수", "태섭", "태웅", "백호", "소연")
        );
        assertThat(output()).contains(ErrorMessage.MATCHING_FAIL.getErrorMessage());
    }

    @Test
    void 매칭_조회_실패() {
        assertSimpleTest(
                () -> {
                    runException("2", "백엔드, 레벨1, 로또");
                    assertThat(output()).contains(ErrorMessage.MATCHING_NO_EXIST.getErrorMessage());
                }
        );
    }

    @Test
    void 없는_과정에_대한_예외_처리() {
        assertSimpleTest(
                () -> {
                    runException("1", "엔드, 레벨1, 오징어게임");
                    assertThat(output()).contains(ErrorMessage.COURSE_ERROR.getErrorMessage());
                }
        );
    }

    @Test
    void 없는_레벨에_대한_예외_처리() {
        assertSimpleTest(
                () -> {
                    runException("1", "백엔드, 레벨0, 오징어게임");
                    assertThat(output()).contains(ErrorMessage.LEVEL_ERROR.getErrorMessage());
                }
        );
    }

    @Test
    void 해당_레벨에_없는_미션에_대한_예외_처리() {
        assertSimpleTest(
                () -> {
                    runException("1", "백엔드, 레벨1, 장바구니");
                    assertThat(output()).contains(ErrorMessage.MISSION_ERROR.getErrorMessage());
                }
        );
    }

    @Test
    void 기능선택에_대한_예외_처리() {
        assertSimpleTest(
                () -> {
                    runException("4");
                    assertThat(output()).contains(ErrorMessage.FORMAT_ERROR.getErrorMessage());
                }
        );
    }

    @Test
    void 재매칭여부_선택에_대한_예외_처리() {
        assertSimpleTest(
                () -> {
                    runException("1", "백엔드, 레벨1, 장바구니", "1", "예");
                    assertThat(output()).contains(ErrorMessage.FORMAT_ERROR.getErrorMessage());
                }
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
