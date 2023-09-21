package baekjoon.implementation.b8979.view.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class InputValidatorTest {

    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    @DisplayName("입력이 공백이면 예외가 발생한다.")
    void validateInput_Blank(String input) {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> InputValidator.validateInput(input));
        assertEquals("입력은 공백일 수 없습니다.", exception.getMessage());
    }

    @Test
    @DisplayName("입력이 공백이면 예외가 발생한다.")
    void validateInput_null() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> InputValidator.validateInput(null));
        assertEquals("입력은 공백일 수 없습니다.", exception.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"1 a", "1 !", "1, 2"})
    @DisplayName("입력이 숫자가 아니면 예외가 발생한다.")
    void isNotDigit(String input) {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> InputValidator.validateInput(input));
        assertEquals("숫자만 입력 가능합니다.", exception.getMessage());
    }
}