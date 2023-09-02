package baekjoon.implementation.b16236.utils;

import java.util.Arrays;
import java.util.regex.Pattern;

public class Validator {
    private static final int MIN_VALUE_OF_N = 2;
    private static final int MAX_VALUE_OF_N = 20;

    public static void validateN(String input) {
        if (isNotDigit(input)) {
            throw new IllegalArgumentException("N의 크기에 대한 입력은 숫자로만 가능합니다.");
        }
        if (isInvalidRange(input)) {
            throw new IllegalArgumentException("N의 크기는 2에서 20사이어야 합니다.");
        }
    }

    private static boolean isNotDigit(String input) {
        return !Pattern.matches("-?[0-9]+", input);
    }

    private static boolean isInvalidRange(String input) {
        int n = Integer.parseInt(input);
        return n < MIN_VALUE_OF_N || n > MAX_VALUE_OF_N;
    }

    public static void validateBoard(String[] input, int n) {
        if (isInvalidSize(input, n)) {
            throw new IllegalArgumentException("배열의 입력 개수는 공백을 기준으로 " + n + "개여야 합니다.");
        }
        if (hasInvalidInput(input)) {
            throw new IllegalArgumentException("배열에 대한 입력은 숫자만 가능합니다.");
        }
    }

    private static boolean isInvalidSize(String[] input, int n) {
        return input.length != n;
    }

    private static boolean hasInvalidInput(String[] input) {
        return Arrays.stream(input)
                .anyMatch(Validator::isNotDigit);
    }
}
