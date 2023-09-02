package baekjoon.implementation.b16236.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ValidatorTest {

    @ParameterizedTest
    @ValueSource(strings = {"a", "!", "12$"})
    @DisplayName("N에 대한 입력이 숫자가 아니면 예외가 발생한다.")
    void validateN_isNotDigit(String input) {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> Validator.validateN(input));
        assertEquals("N의 크기에 대한 입력은 숫자로만 가능합니다.", exception.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "21"})
    @DisplayName("N에 대한 크기가 2보다 작고 20보다 크다면 예외가 발생한다.")
    void validateN_isInvalidRange(String input) {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> Validator.validateN(input));
        assertEquals("N의 크기는 2에서 20사이어야 합니다.", exception.getMessage());
    }

    @Test
    @DisplayName("배열에 대한 입력 중 숫자가 아닌 것이 있으면 예외가 발생한다.")
    void validateBoard_isNotDigit() {
        String[] input = {"0", "1", "a"};

        Exception exception = assertThrows(IllegalArgumentException.class, () -> Validator.validateBoard(input, 3));
        assertEquals("배열에 대한 입력은 숫자만 가능합니다.", exception.getMessage());
    }

    @Test
    @DisplayName("배열의 크기가 올바르지 않으면 예외가 발생한다.")
    void validateBoard_isInvalidSize() {
        String[] input = {"0", "1"};
        int n = 3;

        Exception exception = assertThrows(IllegalArgumentException.class, () -> Validator.validateBoard(input, n));
        assertEquals("배열의 입력 개수는 공백을 기준으로 " + n + "개여야 합니다.", exception.getMessage());
    }
}