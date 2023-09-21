package baekjoon.implementation.b8979.view.validator;

import baekjoon.implementation.b8979.utils.Constants;

import java.util.Arrays;
import java.util.regex.Pattern;

public class InputValidator {
    public static void validateInput(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("입력은 공백일 수 없습니다.");
        }

        if (isInvalidInput(input)) {
            throw new IllegalArgumentException("숫자만 입력 가능합니다.");
        }
    }

    private static boolean isInvalidInput(String input) {
        return Arrays.stream(input.split(Constants.DELIMITER))
                .anyMatch(InputValidator::isNotDigit);
    }

    private static boolean isNotDigit(String input) {
        return !Pattern.matches("-?[0-9]+", input);
    }
}
