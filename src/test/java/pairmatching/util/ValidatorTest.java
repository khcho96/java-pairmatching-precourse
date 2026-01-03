package pairmatching.util;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import pairmatching.constant.ErrorMessage;

class ValidatorTest {

    @Test
    void _통과한다() {
        Validator.validateCsvFormat("백엔드,레벨1,로또");
    }

    @Test
    void _예외를_던진다() {
        assertThatThrownBy(() -> Validator.validateCsvFormat("백엔드,,로또"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.FORMAT_ERROR.getErrorMessage());
    }
}